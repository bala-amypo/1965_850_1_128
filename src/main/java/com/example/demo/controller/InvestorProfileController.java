package com.example.demo.controller;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.InvestorProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {

    private final InvestorProfileService investorProfileService;

    public InvestorProfileController(InvestorProfileService investorProfileService) {
        this.investorProfileService = investorProfileService;
    }

    @PostMapping
    public ResponseEntity<InvestorProfile> createInvestor(@RequestBody InvestorProfile investor) {
        InvestorProfile created = investorProfileService.createInvestor(investor);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestorProfile> getInvestorById(@PathVariable Long id) {
        InvestorProfile investor = investorProfileService.getInvestorById(id);
        return ResponseEntity.ok(investor);
    }

    @GetMapping
    public ResponseEntity<List<InvestorProfile>> getAllInvestors() {
        List<InvestorProfile> investors = investorProfileService.getAllInvestors();
        return ResponseEntity.ok(investors);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<InvestorProfile> updateInvestorStatus(
            @PathVariable Long id, @RequestParam boolean active) {
        InvestorProfile updated = investorProfileService.updateInvestorStatus(id, active);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/lookup/{investorId}")
    public ResponseEntity<InvestorProfile> getByInvestorId(@PathVariable String investorId) {
        Optional<InvestorProfile> investor = investorProfileService.findByInvestorId(investorId);
        return investor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}