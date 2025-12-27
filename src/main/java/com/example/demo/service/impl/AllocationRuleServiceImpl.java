package com.example.demo.config;

import java.util.List;

import org.springframework.stereotype.Service;

import sbs.rosedev.springFirst.entity.AssetClassAllocationRule;
import sbs.rosedev.springFirst.exception.ResourceNotFoundException;
import sbs.rosedev.springFirst.repository.AssetClassAllocationRuleRepository;
import sbs.rosedev.springFirst.service.AllocationRuleService;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {
    private final AssetClassAllocationRuleRepository repo;

    public AllocationRuleServiceImpl(AssetClassAllocationRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        if (rule.getTargetPercentage() < 0 || rule.getTargetPercentage() > 100)
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        return repo.save(rule);
    }
    
    @Override
    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule data) {
        AssetClassAllocationRule r = repo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Rule not found: " + id));
        r.setTargetPercentage(data.getTargetPercentage());
        return repo.save(r);
    }
    
    @Override
    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }
}
