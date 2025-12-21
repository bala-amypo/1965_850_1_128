package com.example.demo.service;

import com.example.demo.entity.HoldingRecord;
import java.util.List;

public interface HoldingRecordService {

    // Validate holding value > 0
    HoldingRecord recordHolding(HoldingRecord holding);

    List<HoldingRecord> getHoldingsByInvestor(Long investorId);

    HoldingRecord getHoldingById(Long id);

    List<HoldingRecord> getAllHoldings();
}
