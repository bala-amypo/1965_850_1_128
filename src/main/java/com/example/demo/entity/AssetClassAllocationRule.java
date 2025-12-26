package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;

@Entity
@Table(name = "asset_class_allocation_rule")
public class AssetClassAllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private double targetPercentage;

    private boolean active;

    public AssetClassType getAssetClass() {
        return assetClass;
    }

    public double getTargetPercentage() {
        return targetPercentage;
    }

    public boolean isActive() {
        return active;
    }
}
