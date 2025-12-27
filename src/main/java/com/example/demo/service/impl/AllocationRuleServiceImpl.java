package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AssetClassAllocationRuleRepository ruleRepository;

    public AllocationRuleServiceImpl(AssetClassAllocationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return ruleRepository.findByInvestorId(investorId);
    }

    @Override
    public List<AssetClassAllocationRule> getActiveRules(Long investorId) {
        return ruleRepository.findByInvestorIdAndActiveTrue(investorId);
    }

    // Ensure your other methods (createRule, updateRule, getRuleById) are implemented below...
    @Override
    public AssetClassAllocationRule getRuleById(Long id) {
        return ruleRepository.findById(id).orElse(null);
    }
    
    @Override
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule updatedRule) {
        updatedRule.setId(id);
        return ruleRepository.save(updatedRule);
    }
}