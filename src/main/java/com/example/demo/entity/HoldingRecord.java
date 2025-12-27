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
    private AssetClassType assetClassType; // Changed from String assetClass to Enum

    private double percentage; // Added/Renamed to match service call

    public HoldingRecord() {}

    public Long getId() { return id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClassType() { return assetClassType; }
    public double getPercentage() { return percentage; }

    public void setAssetClassType(AssetClassType assetClassType) { this.assetClassType = assetClassType; }
    public void setPercentage(double percentage) { this.percentage = percentage; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }
}