package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.entity.enums.AlertSeverity;
import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.AllocationSnapshotService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository snapshotRecordRepository;
    private final HoldingRecordRepository holdingRecordRepository;
    private final AssetClassAllocationRuleRepository allocationRuleRepository;
    private final RebalancingAlertRecordRepository alertRecordRepository;

    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRecordRepository snapshotRecordRepository,
            HoldingRecordRepository holdingRecordRepository,
            AssetClassAllocationRuleRepository allocationRuleRepository,
            RebalancingAlertRecordRepository alertRecordRepository) {
        this.snapshotRecordRepository = snapshotRecordRepository;
        this.holdingRecordRepository = holdingRecordRepository;
        this.allocationRuleRepository = allocationRuleRepository;
        this.alertRecordRepository = alertRecordRepository;
    }

    @Override
    public AllocationSnapshotRecord computeSnapshot(Long investorId) {
        List<HoldingRecord> holdings = holdingRecordRepository.findByInvestorId(investorId);
        if (holdings.isEmpty()) {
            throw new IllegalArgumentException("No holdings found for investor: " + investorId);
        }

        double totalValue = holdings.stream()
                .mapToDouble(HoldingRecord::getCurrentValue)
                .sum();

        if (totalValue <= 0) {
            throw new IllegalArgumentException("Total portfolio value must be > 0");
        }

        Map<AssetClassType, Double> allocationMap = new HashMap<>();
        for (HoldingRecord holding : holdings) {
            allocationMap.merge(holding.getAssetClass(), holding.getCurrentValue(), Double::sum);
        }

        Map<AssetClassType, Double> percentageMap = new HashMap<>();
        for (Map.Entry<AssetClassType, Double> entry : allocationMap.entrySet()) {
            percentageMap.put(entry.getKey(), (entry.getValue() / totalValue) * 100.0);
        }

        StringBuilder jsonBuilder = new StringBuilder("{");
        boolean first = true;
        for (Map.Entry<AssetClassType, Double> entry : percentageMap.entrySet()) {
            if (!first) jsonBuilder.append(",");
            jsonBuilder.append("\"").append(entry.getKey()).append("\":").append(entry.getValue());
            first = false;
        }
        jsonBuilder.append("}");

        AllocationSnapshotRecord snapshot = new AllocationSnapshotRecord(
                investorId, LocalDateTime.now(), totalValue, jsonBuilder.toString());
        snapshot = snapshotRecordRepository.save(snapshot);

        List<AssetClassAllocationRule> activeRules = 
                allocationRuleRepository.findByInvestorIdAndActiveTrue(investorId);

        for (AssetClassAllocationRule rule : activeRules) {
            Double currentPercentage = percentageMap.get(rule.getAssetClass());
            if (currentPercentage != null && currentPercentage > rule.getTargetPercentage()) {
                double drift = currentPercentage - rule.getTargetPercentage();
                AlertSeverity severity;
                if (drift > 10) {
                    severity = AlertSeverity.HIGH;
                } else if (drift > 5) {
                    severity = AlertSeverity.MEDIUM;
                } else {
                    severity = AlertSeverity.LOW;
                }

                RebalancingAlertRecord alert = new RebalancingAlertRecord(
                        investorId,
                        rule.getAssetClass(),
                        currentPercentage,
                        rule.getTargetPercentage(),
                        severity,
                        String.format("Asset class %s is %.2f%% over target", 
                                rule.getAssetClass(), drift),
                        LocalDateTime.now(),
                        false
                );
                alertRecordRepository.save(alert);
            }
        }

        return snapshot;
    }

    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapshotRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Snapshot not found with id: " + id));
    }

    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId) {
        return snapshotRecordRepository.findByInvestorId(investorId);
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRecordRepository.findAll();
    }
}