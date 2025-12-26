package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "holding_records")
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String assetName;

    @Column(nullable = false)
    private Double value;

    // getters & setters
}
