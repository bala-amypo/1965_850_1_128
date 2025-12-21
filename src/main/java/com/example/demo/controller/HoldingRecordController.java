package com.example.demo.controller;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.service.HoldingRecordService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class HoldingRecordController {

    private final HoldingRecordService holdingRecordService;

    public HoldingRecordController(HoldingRecordService holdingRecordService) {
        this.holdingRecordService = holdingRecordService;
    }

    // POST /api/holdings - Record holding
    @PostMapping
    public ResponseEntity<HoldingRecord> recordHolding(
            @RequestBody HoldingRecord holdingRecord) {

        HoldingRecord saved =
                holdingRecordService.recordHolding(holdingRecord);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET /api/holdings/investor/{investorId} - Get holdings by investor
    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<HoldingRecord>> getHoldingsByInvestor(
            @PathVariable Long investorId) {

        return ResponseEntity.ok(
                holdingRecordService.getHoldingsByInvestor(investorId)
        );
    }

    // GET /api/holdings/{id} - Get holding by id
    @GetMapping("/{id}")
    public ResponseEntity<HoldingRecord> getHoldingById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                holdingRecordService.getHoldingById(id)
        );
    }

    // GET /api/holdings - List all holdings
    @GetMapping
    public ResponseEntity<List<HoldingRecord>> getAllHoldings() {

        return ResponseEntity.ok(
                holdingRecordService.getAllHoldings()
        );
    }
}
