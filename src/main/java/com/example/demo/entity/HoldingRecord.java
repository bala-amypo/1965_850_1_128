package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import java.time.LocalDateTime;

public class HoldingRecord {
    private Long id;
    private Long investorId;
    private AssetClassType assetClass;
    private Double currentValue;
    private LocalDateTime asOf;

    public HoldingRecord(Long investorId, AssetClassType assetClass,
                         Double currentValue, LocalDateTime asOf) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentValue = currentValue;
        this.asOf = asOf;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClass() { return assetClass; }
    public Double getCurrentValue() { return currentValue; }
}
