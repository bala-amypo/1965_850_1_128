package com.example.demo.controller;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.InvestorProfileService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {

    private final InvestorProfileService investorProfileService;

    public InvestorProfileController(InvestorProfileService investorProfileService) {
        this.investorProfileService = investorProfileService;
    }

    // POST /api/investors - Create investor
    @PostMapping
    public ResponseEntity<InvestorProfile> createInvestor(
            @RequestBody InvestorProfile investorProfile) {

        InvestorProfile created =
                investorProfileService.createInvestor(investorProfile);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // GET /api/investors/{id} - Get investor by ID
    @GetMapping("/{id}")
    public ResponseEntity<InvestorProfile> getInvestorById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                investorProfileService.getInvestorById(id)
        );
    }

    // GET /api/investors - List all investors
    @GetMapping
    public ResponseEntity<List<InvestorProfile>> getAllInvestors() {

        return ResponseEntity.ok(
                investorProfileService.getAllInvestors()
        );
    }

    // PUT /api/investors/{id}/status - Update status
    @PutMapping("/{id}/status")
    public ResponseEntity<InvestorProfile> updateInvestorStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        return ResponseEntity.ok(
                investorProfileService.updateInvestorStatus(id, active)
        );
    }

    // GET /api/investors/lookup/{investorId} - Lookup
    @GetMapping("/lookup/{investorId}")
    public ResponseEntity<InvestorProfile> lookupByInvestorId(
            @PathVariable String investorId) {

        return ResponseEntity.ok(
                investorProfileService.findByInvestorId(investorId)
        );
    }
}
