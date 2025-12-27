package sbs.rosedev.springFirst.service;

import java.util.List;
import java.util.Optional;

import sbs.rosedev.springFirst.entity.InvestorProfile;

public interface InvestorProfileService {

    InvestorProfile createInvestor(InvestorProfile investor);

    InvestorProfile getInvestorById(Long id);

    List<InvestorProfile> getAllInvestors();

    InvestorProfile updateInvestorStatus(Long id, Boolean active);

    Optional<InvestorProfile> findByInvestorId(String investorId);
}
