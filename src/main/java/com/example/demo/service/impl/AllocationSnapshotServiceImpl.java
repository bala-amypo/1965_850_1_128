package sbs.rosedev.springFirst.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import sbs.rosedev.springFirst.entity.AllocationSnapshotRecord;
import sbs.rosedev.springFirst.entity.HoldingRecord;
import sbs.rosedev.springFirst.exception.ResourceNotFoundException;
import sbs.rosedev.springFirst.repository.AllocationSnapshotRecordRepository;
import sbs.rosedev.springFirst.repository.AssetClassAllocationRuleRepository;
import sbs.rosedev.springFirst.repository.HoldingRecordRepository;
import sbs.rosedev.springFirst.repository.RebalancingAlertRecordRepository;
import sbs.rosedev.springFirst.service.AllocationSnapshotService;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {
    private final AllocationSnapshotRecordRepository snapRepo;
    private final HoldingRecordRepository holdingRepo;
    private final AssetClassAllocationRuleRepository ruleRepo;
    private final RebalancingAlertRecordRepository alertRepo;

    public AllocationSnapshotServiceImpl(
        AllocationSnapshotRecordRepository s,
        HoldingRecordRepository h,
        AssetClassAllocationRuleRepository r,
        RebalancingAlertRecordRepository a) {
        this.snapRepo = s;
        this.holdingRepo = h;
        this.ruleRepo = r;
        this.alertRepo = a;
    }

    @Override
    public AllocationSnapshotRecord computeSnapshot(Long investorId) {
        List<HoldingRecord> holdings = holdingRepo.findByInvestorId(investorId);
        if (holdings.isEmpty())
            throw new IllegalArgumentException("No holdings");
        
        double total = holdings.stream().mapToDouble(HoldingRecord::getCurrentValue).sum();
        AllocationSnapshotRecord snap =
        new AllocationSnapshotRecord(investorId, LocalDateTime.now(), total, "{}");
        return snapRepo.save(snap);
    }
    
    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Snapshot not found: " + id));
    }
    
    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapRepo.findAll();
    }
}
