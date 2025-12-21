package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AllocationSnapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    private Double totalPortfolioValue;

    private LocalDateTime calculatedAt;

    public AllocationSnapshot() {}

    public AllocationSnapshot(Long investorId, Double totalPortfolioValue, LocalDateTime calculatedAt) {
        this.investorId = investorId;
        this.totalPortfolioValue = totalPortfolioValue;
        this.calculatedAt = calculatedAt;
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

    public Double getTotalPortfolioValue() {
        return totalPortfolioValue;
    }

    public void setTotalPortfolioValue(Double totalPortfolioValue) {
        this.totalPortfolioValue = totalPortfolioValue;
    }

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }

    public void setCalculatedAt(LocalDateTime calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
}
