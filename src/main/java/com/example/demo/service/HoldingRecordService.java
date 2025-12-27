package sbs.rosedev.springFirst.service;

import java.util.List;
import java.util.Optional;

import sbs.rosedev.springFirst.entity.HoldingRecord;

public interface HoldingRecordService {

    HoldingRecord recordHolding(HoldingRecord holding);

    List<HoldingRecord> getHoldingsByInvestor(Long investorId);

    Optional<HoldingRecord> getHoldingById(Long id);
}
