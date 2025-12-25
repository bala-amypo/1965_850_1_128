package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;
    private LocalDateTime snapshotDate = LocalDateTime.now();
    private Double totalPortfolioValue;

    @Column(columnDefinition = "TEXT")
    private String allocationJson;

    // getters & setters
}
