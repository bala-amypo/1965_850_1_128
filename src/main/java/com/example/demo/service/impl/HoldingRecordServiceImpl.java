package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoldingRecordServiceImpl
        implements HoldingRecordService {

    private final HoldingRecordRepository holdingRecordRepository;

    public HoldingRecordServiceImpl(
            HoldingRecordRepository holdingRecordRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
    }

    @Override
    public HoldingRecord recordHolding(HoldingRecord holding) {

        // 🔴 FIXED: use existing field
        if (holding.getHoldingValue() <= 0) {
            throw new IllegalArgumentException(
                    "Holding value must be greater than 0");
        }

        return holdingRecordRepository.save(holding);
    }

    @Override
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return holdingRecordRepository.findByInvestorId(investorId);
    }

    @Override
    public HoldingRecord getHoldingById(Long id) {
        return holdingRecordRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Holding not found with id: " + id));
    }

    @Override
    public List<HoldingRecord> getAllHoldings() {
        return holdingRecordRepository.findAll();
    }
}
