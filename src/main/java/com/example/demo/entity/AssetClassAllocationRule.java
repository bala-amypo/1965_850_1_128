package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;

public class AssetClassAllocationRule {
    private Long id;
    private Long investorId;
    private AssetClassType assetClass;
    private Double targetPercentage;
    private Boolean active;

    public AssetClassAllocationRule(Long investorId, AssetClassType assetClass,
                                    Double targetPercentage, Boolean active) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.targetPercentage = targetPercentage;
        this.active = active;
    }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClass() { return assetClass; }
    public Double getTargetPercentage() { return targetPercentage; }
    public void setTargetPercentage(Double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }
    public Boolean getActive() { return active; }
}
