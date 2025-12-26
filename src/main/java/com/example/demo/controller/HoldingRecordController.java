package com.example.demo.controller;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.service.HoldingRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class HoldingRecordController {

    private final HoldingRecordService holdingRecordService;

    public HoldingRecordController(HoldingRecordService holdingRecordService) {
        this.holdingRecordService = holdingRecordService;
    }

    @PostMapping
    public ResponseEntity<HoldingRecord> recordHolding(@RequestBody HoldingRecord holding) {
        HoldingRecord created = holdingRecordService.recordHolding(holding);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<HoldingRecord>> getHoldingsByInvestor(@PathVariable Long investorId) {
        List<HoldingRecord> holdings = holdingRecordService.getHoldingsByInvestor(investorId);
        return ResponseEntity.ok(holdings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoldingRecord> getHoldingById(@PathVariable Long id) {
        return holdingRecordService.getHoldingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<HoldingRecord>> getAllHoldings() {
        List<HoldingRecord> holdings = holdingRecordService.getAllHoldings();
        return ResponseEntity.ok(holdings);
    }
}