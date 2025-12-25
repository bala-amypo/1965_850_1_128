public interface AllocationSnapshotRecordRepository
        extends JpaRepository<AllocationSnapshotRecord, Long> {
    List<AllocationSnapshotRecord> findByInvestorId(Long investorId);
}
