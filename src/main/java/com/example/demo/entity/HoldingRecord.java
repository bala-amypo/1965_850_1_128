package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

@Entity
public class InvestorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;
    private LocalDateTime snapshotDate;
    private Double currentValue;
    private assetclass AssetClassType;

    public InvestorProfile() {
    }

    public InvestorProfile(
            Long id,
            Long investorId,
            assetClass AssetClassType,
            Double currentValue,
            LocalDateTime snapshotDate
    ) {
        this.id = id;
        this.investorId = investorId;
        this.AssetClassType = AssetClassType;
        this.currentValue = currentValue;
        this.snapshotDate = snapshotDate;
        
    }

    // Getters & Setters (standard naming)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public assetclass getAssetClassType() {
        return AssetClassType;
    }

    public void setAssetClassType(  assetclass AssetClassType) {
        this.AssetClassType = AssetClassType;
    }

    public Double getcurrentValue() {
        return currentValue;
    }

    public void setcurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public LocalDateTime getsnapshotDate() {
        return snapshotDate;
    }

    public void setsnapshotDate(LocalDateTime snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

}
