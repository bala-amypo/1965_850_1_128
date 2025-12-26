package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "asset_class_allocation_rules")
public class AssetClassAllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String assetClass;

    @Column(nullable = false)
    private Double allocationPercentage;

    // getters & setters
}
