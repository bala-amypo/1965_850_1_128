// package sbs.rosedev.springFirst.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import sbs.rosedev.springFirst.entity.AssetClassAllocationRule;
// import sbs.rosedev.springFirst.services.AllocationRuleServiceImpl;

// @RestController
// @RequestMapping("/api/allocation-rules")
// public class AllocationRuleController {

//     private final AllocationRuleServiceImpl ruleService;

//     public AllocationRuleController(AllocationRuleServiceImpl ruleService) {
//         this.ruleService = ruleService;
//     }

//     @PostMapping
//     public AssetClassAllocationRule createRule(
//             @RequestBody AssetClassAllocationRule rule) {
//         return ruleService.createRule(rule);
//     }

//     @PutMapping("/{id}")
//     public AssetClassAllocationRule updateRule(
//             @PathVariable Long id,
//             @RequestBody AssetClassAllocationRule rule) {
//         return ruleService.updateRule(id, rule);
//     }

//     @GetMapping("/investor/{investorId}")
//     public List<AssetClassAllocationRule> getRulesByInvestor(
//             @PathVariable Long investorId) {
//         return ruleService.getRulesByInvestor(investorId);
//     }

//     @GetMapping("/{id}")
//     public AssetClassAllocationRule getRuleById(@PathVariable Long id) {
//         return ruleService.getRuleById(id);
//     }

//     @GetMapping
//     public List<AssetClassAllocationRule> getAllRules() {
//         return ruleService.getAllRule();
//     }
// }


package com.demo.springFirst.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.demo.springFirst.entity.AssetClassAllocationRule;
import com.demo.springFirst.service.impl.AllocationRuleServiceImpl;

@RestController
@RequestMapping("/api/allocation-rules")
public class AllocationRuleController {

    private final AllocationRuleServiceImpl service;

    public AllocationRuleController(AllocationRuleServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public AssetClassAllocationRule createRule(
            @RequestBody AssetClassAllocationRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public AssetClassAllocationRule updateRule(
            @PathVariable Long id,
            @RequestBody AssetClassAllocationRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/investor/{investorId}")
    public List<AssetClassAllocationRule> getRulesByInvestor(
            @PathVariable Long investorId) {
        return service.getRulesByInvestor(investorId);
    }
}
