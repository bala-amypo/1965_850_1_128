package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;

@Entity
public class AssetClassAllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private double targetPercentage;

    private Boolean active;

    // -------- GETTERS --------

    public Long getId() {
        return id;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public AssetClassType getAssetClass() {
        return assetClass;
    }

    public double getTargetPercentage() {
        return targetPercentage;
    }

    /**
     * Changed to isActive() to resolve the "cannot find symbol" error 
     * in AllocationRuleServiceImpl.
     */
    public Boolean isActive() {
        return active;
    }

    // -------- SETTERS --------

    public void setId(Long id) {
        this.id = id;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public void setAssetClass(AssetClassType assetClass) {
        this.assetClass = assetClass;
    }

    public void setTargetPercentage(double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}