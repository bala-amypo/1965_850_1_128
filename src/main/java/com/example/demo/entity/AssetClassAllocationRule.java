package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "asset_class_allocation_rules")
public class AssetClassAllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetClass;

    private double targetPercentage;

    private boolean active;

    // ===== GETTERS =====
    public Long getId() { return id; }
    public String getAssetClass() { return assetClass; }
    public double getTargetPercentage() { return targetPercentage; }
    public boolean getActive() { return active; }

    // ===== SETTERS =====
    public void setAssetClass(String assetClass) { this.assetClass = assetClass; }
    public void setTargetPercentage(double targetPercentage) { this.targetPercentage = targetPercentage; }
    public void setActive(boolean active) { this.active = active; }
}
