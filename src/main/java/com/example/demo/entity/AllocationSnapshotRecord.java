package com.example.demo.entity;

import java.time.LocalDateTime;

public class AllocationSnapshotRecord {
    private Long id;
    private Long investorId;
    private LocalDateTime snapshotDate;
    private Double totalPortfolioValue;
    private String allocationJson;

    public AllocationSnapshotRecord(Long investorId, LocalDateTime snapshotDate,
                                    Double totalPortfolioValue, String allocationJson) {
        this.investorId = investorId;
        this.snapshotDate = snapshotDate;
        this.totalPortfolioValue = totalPortfolioValue;
        this.allocationJson = allocationJson;
    }

    public Long getInvestorId() { return investorId; }
    public LocalDateTime getSnapshotDate() { return snapshotDate; }
    public Double getTotalPortfolioValue() { return totalPortfolioValue; }
}
