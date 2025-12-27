package sbs.rosedev.springFirst.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import sbs.rosedev.springFirst.entity.enums.AssetClassType;

@Entity
public class HoldingRecord {
    @Id
    private Long id;
    private Long investorId;
    private AssetClassType assetClass;
    private Double currentValue;
    private LocalDateTime createdAt;

    public HoldingRecord(Long investorId, AssetClassType assetClass,
                         Double currentValue, LocalDateTime createdAt) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentValue = currentValue;
        this.createdAt = createdAt;
    }

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

    public AssetClassType getAssetClassType() {
        return assetClass;
    }

    public void setAssetClassType(AssetClassType assetClass) {
        this.assetClass = assetClass;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public AssetClassType getAssetClass() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
