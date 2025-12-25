package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.entity.enums.AlertSeverity;
import jakarta.persistence.*;

@Entity
public class RebalancingAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private Double currentPercentage;
    private Double targetPercentage;

    @Enumerated(EnumType.STRING)
    private AlertSeverity severity;

    private Boolean resolved = false;

    // getters & setters
}
