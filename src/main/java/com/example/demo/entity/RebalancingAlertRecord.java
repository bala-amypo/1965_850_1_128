package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rebalancing_alert_records")
public class RebalancingAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String severity;

    // getters & setters
}
