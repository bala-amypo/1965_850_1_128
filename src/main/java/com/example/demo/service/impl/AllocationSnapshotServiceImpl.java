package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.AllocationSnapshotService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository snapshotRepository;
    private final HoldingRecordRepository holdingRecordRepository;
    private final AssetClassAllocationRuleRepository allocationRuleRepository;

    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRecordRepository snapshotRepository,
            HoldingRecordRepository holdingRecordRepository,
            AssetClassAllocationRuleRepository allocationRuleRepository) {
        this.snapshotRepository = snapshotRepository;
        this.holdingRecordRepository = holdingRecordRepository;
        this.allocationRuleRepository = allocationRuleRepository;
    }

    @Override
    public AllocationSnapshotRecord generateSnapshot(Long investorId) {
        List<HoldingRecord> holdings = holdingRecordRepository.findByInvestorId(investorId);
        List<AssetClassAllocationRule> rules = allocationRuleRepository.findByInvestorIdAndActiveTrue(investorId);

        AllocationSnapshotRecord snapshot = new AllocationSnapshotRecord();
        snapshot.setInvestorId(investorId);

        for (AssetClassAllocationRule rule : rules) {
            double currentPercentage = holdings.stream()
                    .filter(h -> h.getAssetClassType() == rule.getAssetClass())
                    .mapToDouble(HoldingRecord::getPercentage)
                    .sum();

            snapshot.addAllocation(
                    rule.getAssetClass().name(),
                    currentPercentage,
                    rule.getTargetPercentage()
            );
        }
        return snapshotRepository.save(snapshot);
    }

    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapshotRepository.findById(id).orElse(null);
    }

    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId) {
        return snapshotRepository.findByInvestorId(investorId);
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRepository.findAll();
    }
}