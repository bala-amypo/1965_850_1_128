package sbs.rosedev.springFirst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sbs.rosedev.springFirst.entity.HoldingRecord;
import sbs.rosedev.springFirst.entity.enums.AssetClassType;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {
    List<HoldingRecord> findByInvestorId(Long investorId);

    // List<HoldingRecord> findByCurrentValueGreaterThan(Double value);
    // List<HoldingRecord> findByInvestorIdAndAssetClass(Long investorId,
    // AssetClassType assetClass);
    @Query("SELECT h FROM HoldingRecord h WHERE h.currentValue > :value")
    List<HoldingRecord> findByValueGreaterThan(@Param("value") Double value);

    @Query("SELECT h FROM HoldingRecord h WHERE h.investorId = :investorId AND h.assetClass = :assetClass")
    List<HoldingRecord> findByInvestorAndAssetClass(
        @Param("investorId") Long investorId,
        @Param("assetClass") AssetClassType assetClass
    );
}
