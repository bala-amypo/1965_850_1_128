package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "holding_records")
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetClass;

    private double currentValue;

    // ===== GETTERS =====
    public Long getId() { return id; }
    public String getAssetClass() { return assetClass; }
    public double getCurrentValue() { return currentValue; }

    // ===== SETTERS =====
    public void setAssetClass(String assetClass) { this.assetClass = assetClass; }
    public void setCurrentValue(double currentValue) { this.currentValue = currentValue; }
}
