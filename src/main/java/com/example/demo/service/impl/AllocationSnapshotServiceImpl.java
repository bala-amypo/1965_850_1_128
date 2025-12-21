package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.AllocationSnapshotRepository;
import com.example.demo.service.HoldingRecordService;
import com.example.demo.service.AllocationSnapshotService;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRepository allocationRepo;
    private final HoldingRecordService holdingService;

    public AllocationSnapshotServiceImpl(AllocationSnapshotRepository allocationRepo,
                                         HoldingRecordService holdingService) {
        this.allocationRepo = allocationRepo;
        this.holdingService = holdingService;
    }

    @Override
    public AllocationSnapshotRecord computeSnapshot(Long investorId) {

        List<HoldingRecord> holdings = holdingService.getHoldingsByInvestorId(investorId);

        if(holdings.isEmpty()){
            throw new RuntimeException("No holdings found for investor");
        }

        double total = holdings.stream()
                .mapToDouble(HoldingRecord::getHoldingValue)
                .sum();

        String json = holdings.stream()
                .map(h -> h.getAssetType() + ":" + h.getHoldingValue())
                .collect(Collectors.joining(", "));

        AllocationSnapshotRecord snap = new AllocationSnapshotRecord(
                investorId,
                LocalDateTime.now(),
                total,
                "{"+json+"}"
        );

        return allocationRepo.save(snap);
    }

    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return allocationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Snapshot not found"));
    }

    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId) {
        return allocationRepo.findByInvestorId(investorId);
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return allocationRepo.findAll();
    }
}
