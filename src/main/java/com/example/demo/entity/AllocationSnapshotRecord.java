package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "allocation_snapshots")
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime snapshotTime;

    private double totalValue;

    private String summary;

    // REQUIRED NO-ARGS CONSTRUCTOR
    public AllocationSnapshotRecord() {}

    // CONSTRUCTOR USED BY SERVICE
    public AllocationSnapshotRecord(Long id, LocalDateTime snapshotTime,
                                    double totalValue, String summary) {
        this.id = id;
        this.snapshotTime = snapshotTime;
        this.totalValue = totalValue;
        this.summary = summary;
    }

    // GETTERS
    public LocalDateTime getSnapshotTime() { return snapshotTime; }
    public double getTotalValue() { return totalValue; }
}
