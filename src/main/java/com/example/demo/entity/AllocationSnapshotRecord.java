package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "allocation_snapshot_records")
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String snapshotDate;

    @Column(nullable = false)
    private Double totalValue;

    // getters & setters
}
