package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "allocation_snapshot_records")
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    private Double totalValue;

    private String allocationJson; // you can store JSON snapshot here

    private LocalDateTime snapshotDateTime;

    // ========= Constructors =========

    public AllocationSnapshotRecord() {
    }

    public AllocationSnapshotRecord(Long investorId, Double totalValue, String allocationJson, LocalDateTime snapshotDateTime) {
        this.investorId = investorId;
        this.totalValue = totalValue;
        this.allocationJson = allocationJson;
        this.snapshotDateTime = snapshotDateTime;
    }

    // ========= Getter + Setter ==========

    public Long getId() {
        return id;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public String getAllocationJson() {
        return allocationJson;
    }

    public void setAllocationJson(String allocationJson) {
        this.allocationJson = allocationJson;
    }

    public LocalDateTime getSnapshotDateTime() {
        return snapshotDateTime;
    }

    public void setSnapshotDateTime(LocalDateTime snapshotDateTime) {
        this.snapshotDateTime = snapshotDateTime;
    }
}
