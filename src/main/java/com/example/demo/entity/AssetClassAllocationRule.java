package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


import java.time.LocalDateTime;

@Entity
public class InvestorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;
    private Enum:AssetClassType assetClass;

    
    private Double targetPercentage;

    private Boolean active;



    // Required by JPA
    public InvestorProfile() {
    }

    public InvestorProfile(
            Long id,
            Long investorId,
            Enum:AssetClassType assetClass,
            Double targetPercentage,
            Boolean active,
            
    ) {
        this.id = id;
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.targetPercentage = targetPercentage;
        this.active = active;
    }

    // Getters & Setters (standard naming)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorId) {
        this.investorId = investorId;
    }

    public String getassetClass() {
        return  assetClass;
    }

    public void setassetClass( Enum:AssetClassType assetClass) {
        this.assetClass = assetClass;
    }

    public Double gettargetPercentage() {
        return targetPercentage;
    }

    public void settargetPercentage(Double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    public Boolean getactive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
