package com.example.demo.service.impl;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.InvestorProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorProfileServiceImpl
        implements InvestorProfileService {

    private final InvestorProfileRepository investorProfileRepository;

    public InvestorProfileServiceImpl(
            InvestorProfileRepository investorProfileRepository) {
        this.investorProfileRepository = investorProfileRepository;
    }

    @Override
    public InvestorProfile createInvestor(InvestorProfile investor) {
        return investorProfileRepository.save(investor);
    }

    @Override
    public InvestorProfile getInvestorById(Long id) {
        return investorProfileRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Investor not found with id: " + id));
    }

    @Override
    public InvestorProfile findByInvestorId(String investorId) {
        return investorProfileRepository.findByInvestorId(investorId)
                .orElseThrow(() ->
                        new RuntimeException("Investor not found with investorId: " + investorId));
    }

    // 🔴 FIXED return type
    @Override
    public List<InvestorProfile> getAllInvestors() {
        return investorProfileRepository.findAll();
    }

    @Override
    public InvestorProfile updateInvestorStatus(Long id, boolean active) {
        InvestorProfile investor = getInvestorById(id);
        investor.setActive(active);
        return investorProfileRepository.save(investor);
    }
}
