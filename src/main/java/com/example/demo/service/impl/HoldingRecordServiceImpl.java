package sbs.rosedev.springFirst.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import sbs.rosedev.springFirst.entity.HoldingRecord;
import sbs.rosedev.springFirst.repository.HoldingRecordRepository;
import sbs.rosedev.springFirst.service.HoldingRecordService;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {
    private final HoldingRecordRepository repo;

    public HoldingRecordServiceImpl(HoldingRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public HoldingRecord recordHolding(HoldingRecord h) {
        if (h.getCurrentValue() <= 0)
            throw new IllegalArgumentException("Value must be > 0");
        return repo.save(h);
    }
    
    @Override
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }
    
    @Override
    public Optional<HoldingRecord> getHoldingById(Long id) {
        return repo.findById(id);
    }
}
