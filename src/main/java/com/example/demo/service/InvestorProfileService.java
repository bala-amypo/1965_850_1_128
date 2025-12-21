package com.example.demo.service;

import com.example.demo.entity.Zone;
import java.util.List;

public interface ZoneService {

    InvestorProfile createInvestor(InvestorProfile investor);

    InvestorProfile getInvestorById(Long id);

    InvestorProfile findByInvestorId(String investorId);

    getAllInvestors(();

    void deactivateZone(Long id);
}