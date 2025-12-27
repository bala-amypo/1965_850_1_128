// package sbs.rosedev.springFirst.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import sbs.rosedev.springFirst.entity.InvestorProfile;
// import sbs.rosedev.springFirst.services.InvestorProfileService;

// @RestController
// @RequestMapping("/api/investors")
// public class InvestorProfileController {
//     private final InvestorProfileService investorProfileService;

//     public InvestorProfileController(InvestorProfileService investorProfileService) {
//         this.investorProfileService = investorProfileService;
//     }

//     @PostMapping("/")
//     public InvestorProfile postInvestorProfile(@RequestBody InvestorProfile investor) {
//         return investorProfileService.createInvestorProfile(investor);
//     }

//     @GetMapping("/{id}")
//     public InvestorProfile getInvestorProfile(@PathVariable Long id) {
//         return investorProfileService.getInvestorById(id);
//     }
    
//     @GetMapping
//     public List<InvestorProfile> getAllInvestorProfile() {
//         return investorProfileService.getAllInvestors();
//     }

//     @PutMapping("/{id}/status")
//     public InvestorProfile putInvestorProfile(@PathVariable Long id, @RequestParam boolean active) {
//         return investorProfileService.updateInvestorStatus(id, active);
//     }

//     @GetMapping("/lookup/{investorId}")
//     public InvestorProfile getMethodName(@PathVariable String investorID) {
//         return investorProfileService.findInvestorById(investorID);
//     }    
// }

package sbs.rosedev.springFirst.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import sbs.rosedev.springFirst.entity.InvestorProfile;
import sbs.rosedev.springFirst.service.impl.InvestorProfileServiceImpl;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {

    private final InvestorProfileServiceImpl service;

    public InvestorProfileController(InvestorProfileServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public InvestorProfile createInvestor(@RequestBody InvestorProfile investor) {
        return service.createInvestor(investor);
    }

    @GetMapping("/{id}")
    public InvestorProfile getInvestorById(@PathVariable Long id) {
        return service.getInvestorById(id);
    }

    @GetMapping
    public List<InvestorProfile> getAllInvestors() {
        return service.getAllInvestors();
    }

    @PutMapping("/{id}/status")
    public InvestorProfile updateStatus(
            @PathVariable Long id,
            @RequestParam Boolean active) {
        return service.updateInvestorStatus(id, active);
    }

    @GetMapping("/lookup/{investorId}")
    public Optional<InvestorProfile> findByInvestorId(
            @PathVariable String investorId) {
        return service.findByInvestorId(investorId);
    }
}
