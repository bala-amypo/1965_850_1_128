// package sbs.rosedev.springFirst.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import sbs.rosedev.springFirst.entity.RebalancingAlertRecord;
// import sbs.rosedev.springFirst.services.RebalancingAlertServiceImpl;

// @RestController
// @RequestMapping("/api/alerts")
// public class RebalancingAlertController {

//     private final RebalancingAlertServiceImpl alertService;

//     public RebalancingAlertController(
//             RebalancingAlertServiceImpl alertService) {
//         this.alertService = alertService;
//     }

//     @PostMapping
//     public RebalancingAlertRecord createAlert(
//             @RequestBody RebalancingAlertRecord alert) {
//         return alertService.createAlert(alert);
//     }

//     @PutMapping("/{id}/resolve")
//     public RebalancingAlertRecord resolveAlert(
//             @PathVariable Long id) {
//         return alertService.resolveAlert(id);
//     }

//     @GetMapping("/investor/{investorId}")
//     public List<RebalancingAlertRecord> getAlertsByInvestor(
//             @PathVariable Long investorId) {
//         return alertService.getAlertsByInvestor(investorId);
//     }

//     @GetMapping("/{id}")
//     public RebalancingAlertRecord getAlertById(
//             @PathVariable Long id) {
//         return alertService.getAlertById(id);
//     }

//     @GetMapping
//     public List<RebalancingAlertRecord> getAllAlerts() {
//         return alertService.getAllAlerts();
//     }
// }

package sbs.rosedev.springFirst.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import sbs.rosedev.springFirst.entity.RebalancingAlertRecord;
import sbs.rosedev.springFirst.service.impl.RebalancingAlertServiceImpl;

@RestController
@RequestMapping("/api/alerts")
public class RebalancingAlertController {

    private final RebalancingAlertServiceImpl service;

    public RebalancingAlertController(RebalancingAlertServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public RebalancingAlertRecord createAlert(
            @RequestBody RebalancingAlertRecord alert) {
        return service.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public RebalancingAlertRecord resolveAlert(
            @PathVariable Long id) {
        return service.resolveAlert(id);
    }

    @GetMapping("/investor/{investorId}")
    public List<RebalancingAlertRecord> getAlertsByInvestor(
            @PathVariable Long investorId) {
        return service.getAlertsByInvestor(investorId);
    }
}
