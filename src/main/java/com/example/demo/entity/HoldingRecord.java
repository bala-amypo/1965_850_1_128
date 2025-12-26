package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "holding_record")
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    private String assetClass;   // 👈 STRING (IMPORTANT)

    private double currentValue;

    public Long getId() {
        return id;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public double getCurrentValue() {
        return currentValue;
    }
}
