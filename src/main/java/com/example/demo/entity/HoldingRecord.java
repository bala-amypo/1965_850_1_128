package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;

@Entity
@Table(name = "holding_record")
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClassType;

    private double percentage;
    private double currentValue; // Add this field if it's missing

    public HoldingRecord() {}

    // --- GETTERS ---
    public Long getId() { return id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClassType() { return assetClassType; }
    public double getPercentage() { return percentage; }
    
    // This is the specific method the error is looking for
    public double getCurrentValue() { return currentValue; }

    // --- SETTERS ---
    public void setInvestorId(Long investorId) { this.investorId = investorId; }
    public void setAssetClassType(AssetClassType assetClassType) { this.assetClassType = assetClassType; }
    public void setPercentage(double percentage) { this.percentage = percentage; }
    public void setCurrentValue(double currentValue) { this.currentValue = currentValue; }
}