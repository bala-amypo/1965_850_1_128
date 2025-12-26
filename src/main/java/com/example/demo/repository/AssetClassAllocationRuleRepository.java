public interface AssetClassAllocationRuleRepository extends JpaRepository<AssetClassAllocationRule, Long> {
    List<AssetClassAllocationRule> findByInvestorId(Long investorId);

    @Query("SELECT r FROM AssetClassAllocationRule r WHERE r.investorId = :investorId AND r.active = true")
    List<AssetClassAllocationRule> findActiveRulesHql(Long investorId);
}
