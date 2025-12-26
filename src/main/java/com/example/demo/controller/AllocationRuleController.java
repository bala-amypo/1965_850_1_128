package com.example.demo.controller;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.service.AllocationRuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/allocation-rules")
public class AllocationRuleController {

    private final AllocationRuleService allocationRuleService;

    public AllocationRuleController(AllocationRuleService allocationRuleService) {
        this.allocationRuleService = allocationRuleService;
    }

    @PostMapping
    public ResponseEntity<AssetClassAllocationRule> createRule(@RequestBody AssetClassAllocationRule rule) {
        AssetClassAllocationRule created = allocationRuleService.createRule(rule);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetClassAllocationRule> updateRule(
            @PathVariable Long id, @RequestBody AssetClassAllocationRule rule) {
        AssetClassAllocationRule updated = allocationRuleService.updateRule(id, rule);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<AssetClassAllocationRule>> getRulesByInvestor(@PathVariable Long investorId) {
        List<AssetClassAllocationRule> rules = allocationRuleService.getRulesByInvestor(investorId);
        return ResponseEntity.ok(rules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetClassAllocationRule> getRuleById(@PathVariable Long id) {
        AssetClassAllocationRule rule = allocationRuleService.getRuleById(id);
        return ResponseEntity.ok(rule);
    }

    @GetMapping
    public ResponseEntity<List<AssetClassAllocationRule>> getAllRules() {
        return ResponseEntity.ok(allocationRuleService.getRulesByInvestor(null));
    }
}