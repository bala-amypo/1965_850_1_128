package sbs.rosedev.springFirst.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import sbs.rosedev.springFirst.entity.RebalancingAlertRecord;
import sbs.rosedev.springFirst.exception.ResourceNotFoundException;
import sbs.rosedev.springFirst.repository.RebalancingAlertRecordRepository;
import sbs.rosedev.springFirst.service.RebalancingAlertService;

@Service
public class RebalancingAlertServiceImpl implements RebalancingAlertService {
    private final RebalancingAlertRecordRepository repo;

    public RebalancingAlertServiceImpl(RebalancingAlertRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {
        if (alert.getCurrentPercentage() <= alert.getTargetPercentage())
            throw new IllegalArgumentException("currentPercentage > targetPercentage");
        return repo.save(alert);
    }
    
    @Override
    public RebalancingAlertRecord resolveAlert(Long id) {
        RebalancingAlertRecord alert = repo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Alert not found: " + id));
        alert.setResolved(true);
        return repo.save(alert);
    }
    
    @Override
    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }
}
