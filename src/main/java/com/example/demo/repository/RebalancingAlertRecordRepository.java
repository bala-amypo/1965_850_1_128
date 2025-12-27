package sbs.rosedev.springFirst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sbs.rosedev.springFirst.entity.RebalancingAlertRecord;

public interface RebalancingAlertRecordRepository extends JpaRepository<RebalancingAlertRecord, Long> {
    List<RebalancingAlertRecord> findByInvestorId(Long investorId);
    // List<RebalancingAlertRecord> findByResolvedFalse();
}