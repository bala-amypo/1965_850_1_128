@Service
public class AllocationSnapshotServiceImpl {

    private final AllocationSnapshotRecordRepository snapshotRepo;
    private final HoldingRecordRepository holdingRepo;
    private final AssetClassAllocationRuleRepository ruleRepo;
    private final RebalancingAlertRecordRepository alertRepo;

    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRecordRepository snapshotRepo,
            HoldingRecordRepository holdingRepo,
            AssetClassAllocationRuleRepository ruleRepo,
            RebalancingAlertRecordRepository alertRepo) {

        this.snapshotRepo = snapshotRepo;
        this.holdingRepo = holdingRepo;
        this.ruleRepo = ruleRepo;
        this.alertRepo = alertRepo;
    }

    public AllocationSnapshotRecord computeSnapshot(Long investorId) {

        List<HoldingRecord> holdings = holdingRepo.findByInvestorId(investorId);
        if (holdings.isEmpty()) throw new RuntimeException("No holdings");

        double total = holdings.stream().mapToDouble(HoldingRecord::getCurrentValue).sum();
        if (total <= 0) throw new RuntimeException("must be > 0");

        Map<AssetClassType, Double> map = new HashMap<>();
        for (HoldingRecord h : holdings) {
            map.merge(h.getAssetClass(), h.getCurrentValue(), Double::sum);
        }

        AllocationSnapshotRecord snap = new AllocationSnapshotRecord();
        snap.setInvestorId(investorId);
        snap.setTotalPortfolioValue(total);
        snap.setAllocationJson(map.toString());
        snapshotRepo.save(snap);

        List<AssetClassAllocationRule> rules = ruleRepo.findActiveRulesHql(investorId);
        for (AssetClassAllocationRule r : rules) {
            double currentPct = (map.getOrDefault(r.getAssetClass(), 0.0) / total) * 100;
            if (currentPct > r.getTargetPercentage()) {
                RebalancingAlertRecord alert = new RebalancingAlertRecord();
                alert.setInvestorId(investorId);
                alert.setAssetClass(r.getAssetClass());
                alert.setCurrentPercentage(currentPct);
                alert.setTargetPercentage(r.getTargetPercentage());
                alert.setSeverity(AlertSeverity.HIGH);
                alertRepo.save(alert);
            }
        }
        return snap;
    }
}
