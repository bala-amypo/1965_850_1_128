package sbs.rosedev.springFirst.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import sbs.rosedev.springFirst.entity.InvestorProfile;
import sbs.rosedev.springFirst.exception.ResourceNotFoundException;
import sbs.rosedev.springFirst.repository.InvestorProfileRepository;
import sbs.rosedev.springFirst.service.InvestorProfileService;

@Service
public class InvestorProfileServiceImpl implements InvestorProfileService {
    private final InvestorProfileRepository repo;

    public InvestorProfileServiceImpl(InvestorProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public InvestorProfile createInvestor(InvestorProfile p) {
        return repo.save(p);
    }
    
    @Override
    public InvestorProfile getInvestorById(Long id) {
        return repo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Investor not found: " + id));
    }
    
    @Override
    public List<InvestorProfile> getAllInvestors() {
        return repo.findAll();
    }
    
    @Override
    public InvestorProfile updateInvestorStatus(Long id, Boolean active) {
        InvestorProfile p = getInvestorById(id);
        p.setActive(active);
        return repo.save(p);
    }
    
    @Override
    public Optional<InvestorProfile> findByInvestorId(String investorId) {
        return repo.findByInvestorId(investorId);
    }
}
