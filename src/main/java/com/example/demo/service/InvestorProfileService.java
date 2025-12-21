package com.example.demo.service;

import com.example.demo.entity.Zone;
import java.util.List;

public interface ZoneService {

    InvestorProfile createInvestor(InvestorProfile investor);

    Zone updateZone(Long id, Zone zone);

    Zone getZoneById(Long id);

    List<Zone> getAllZones();

    void deactivateZone(Long id);
}