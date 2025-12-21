package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "holding_records")
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Used by findByInvestorId(...)
    private Long investorId;

    // Used for validation (value > 0)
    private double value;

    public HoldingRecord() {
    }

    public HoldingRecord(Long investorId, double value) {
        this.investorId = investorId;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    // 🔴 THIS is the getter your service expects
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
