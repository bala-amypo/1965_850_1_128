package com.example.demo.entity;

import com.example.demo.entity.enums.AlertSeverity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rebalancing_alerts")
public class RebalancingAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetClass;

    private Double currentPercentage;
    private double targetPercentage;

    @Enumerated(EnumType.STRING)
    private AlertSeverity severity;

    private String message;

    private LocalDateTime createdAt;

    private boolean resolved;

    // REQUIRED by JPA
    public RebalancingAlertRecord() {}

    // REQUIRED by your service
    public RebalancingAlertRecord(
            Long id,
            String assetClass,
            Double currentPercentage,
            double targetPercentage,
            AlertSeverity severity,
            String message,
            LocalDateTime createdAt,
            boolean resolved
    ) {
        this.id = id;
        this.assetClass = assetClass;
        this.currentPercentage = currentPercentage;
        this.targetPercentage = targetPercentage;
        this.severity = severity;
        this.message = message;
        this.createdAt = createdAt;
        this.resolved = resolved;
    }

    public Double getCurrentPercentage() { return currentPercentage; }
    public double getTargetPercentage() { return targetPercentage; }
    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
