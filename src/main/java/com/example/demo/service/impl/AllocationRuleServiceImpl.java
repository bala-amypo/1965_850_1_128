package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AssetClassAllocationRuleRepository allocationRuleRepository;

    public AllocationRuleServiceImpl(AssetClassAllocationRuleRepository allocationRuleRepository) {
        this.allocationRuleRepository = allocationRuleRepository;
    }

    @Override
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        return allocationRuleRepository.save(rule);
    }

    @Override
    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule updatedRule) {
        AssetClassAllocationRule rule =
                allocationRuleRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Rule not found"));

        rule.setAssetClass(updatedRule.getAssetClass());
        rule.setTargetPercentage(updatedRule.getTargetPercentage());
        rule.setActive(updatedRule.isActive());

        return allocationRuleRepository.save(rule);
    }

    @Override
    public AssetClassAllocationRule getRuleById(Long id) {
        return allocationRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    // ✅ REQUIRED METHOD (FIXES ABSTRACT METHOD ERROR)
    @Override
    public List<AssetClassAllocationRule> getActiveRules(Long investorId) {
        return allocationRuleRepository.findByInvestorIdAndActiveTrue(investorId);
    }
}
