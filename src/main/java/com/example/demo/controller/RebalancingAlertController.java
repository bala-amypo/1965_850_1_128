package com.example.demo.controller;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.service.RebalancingAlertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class RebalancingAlertController {

    private final RebalancingAlertService rebalancingAlertService;

    public RebalancingAlertController(RebalancingAlertService rebalancingAlertService) {
        this.rebalancingAlertService = rebalancingAlertService;
    }

    @PostMapping
    public ResponseEntity<RebalancingAlertRecord> createAlert(@RequestBody RebalancingAlertRecord alert) {
        RebalancingAlertRecord created = rebalancingAlertService.createAlert(alert);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<RebalancingAlertRecord> resolveAlert(@PathVariable Long id) {
        RebalancingAlertRecord resolved = rebalancingAlertService.resolveAlert(id);
        return ResponseEntity.ok(resolved);
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<RebalancingAlertRecord>> getAlertsByInvestor(@PathVariable Long investorId) {
        List<RebalancingAlertRecord> alerts = rebalancingAlertService.getAlertsByInvestor(investorId);
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RebalancingAlertRecord> getAlertById(@PathVariable Long id) {
        RebalancingAlertRecord alert = rebalancingAlertService.getAlertById(id);
        return ResponseEntity.ok(alert);
    }

    @GetMapping
    public ResponseEntity<List<RebalancingAlertRecord>> getAllAlerts() {
        List<RebalancingAlertRecord> alerts = rebalancingAlertService.getAllAlerts();
        return ResponseEntity.ok(alerts);
    }
}