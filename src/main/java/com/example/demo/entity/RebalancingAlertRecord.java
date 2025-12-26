package com.example.demo.entity;

import com.example.demo.entity.enums.*;
import java.time.LocalDateTime;

public class RebalancingAlertRecord {
    private Long id;
    private Long investorId;
    private AssetClassType assetClass;
    private Double currentPercentage;
    private Double targetPercentage;
    private AlertSeverity severity;
    private String message;
    private LocalDateTime createdAt;
    private Boolean resolved;

    public RebalancingAlertRecord(Long investorId, AssetClassType assetClass,
                                  Double currentPercentage, Double targetPercentage,
                                  AlertSeverity severity, String message,
                                  LocalDateTime createdAt, Boolean resolved) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentPercentage = currentPercentage;
        this.targetPercentage = targetPercentage;
        this.severity = severity;
        this.message = message;
        this.createdAt = createdAt;
        this.resolved = resolved;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
    public Double getCurrentPercentage() { return currentPercentage; }
    public Double getTargetPercentage() { return targetPercentage; }
    public AlertSeverity getSeverity() { return severity; }
}
