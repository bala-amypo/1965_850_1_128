package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import java.util.List;

public class AllocationRuleServiceImpl {

    private final AssetClassAllocationRuleRepository repo;

    public AllocationRuleServiceImpl(AssetClassAllocationRuleRepository repo) {
        this.repo = repo;
    }

    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        validate(rule.getTargetPercentage());
        return repo.save(rule);
    }

    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule data) {
        AssetClassAllocationRule rule = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found " + id));
        validate(data.getTargetPercentage());
        rule.setTargetPercentage(data.getTargetPercentage());
        return repo.save(rule);
    }

    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }

    private void validate(Double pct) {
        if (pct < 0 || pct > 100)
            throw new IllegalArgumentException("between 0 and 100");
    }
}
