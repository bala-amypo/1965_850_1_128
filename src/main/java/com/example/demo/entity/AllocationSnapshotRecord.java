package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "allocation_snapshots")
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId; // Added this
    private LocalDateTime snapshotTime = LocalDateTime.now();
    private double totalValue;

    @Column(columnDefinition = "TEXT")
    private String summary = ""; // Stores the allocation details as a string

    public AllocationSnapshotRecord() {}

    // Helper method used by the Service logic
    public void addAllocation(String assetClassName, double current, double target) {
        String entry = String.format("[%s: Current=%.2f%%, Target=%.2f%%] ", 
                        assetClassName, current, target);
        this.summary += entry;
    }

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInvestorId() { return investorId; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }

    public LocalDateTime getSnapshotTime() { return snapshotTime; }
    public void setSnapshotTime(LocalDateTime snapshotTime) { this.snapshotTime = snapshotTime; }

    public double getTotalValue() { return totalValue; }
    public void setTotalValue(double totalValue) { this.totalValue = totalValue; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
}