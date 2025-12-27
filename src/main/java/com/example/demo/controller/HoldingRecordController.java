// package sbs.rosedev.springFirst.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import sbs.rosedev.springFirst.entity.HoldingRecord;
// import sbs.rosedev.springFirst.services.HoldingRecordServiceImpl;

// @RestController
// @RequestMapping("/api/holdings")
// public class HoldingRecordController {

//     private final HoldingRecordServiceImpl holdingService;

//     public HoldingRecordController(HoldingRecordServiceImpl holdingService) {
//         this.holdingService = holdingService;
//     }

//     @PostMapping
//     public HoldingRecord createHolding(
//             @RequestBody HoldingRecord holding) {
//         return holdingService.recordHolding(holding);
//     }

//     @GetMapping("/investor/{investorId}")
//     public List<HoldingRecord> getHoldingsByInvestor(
//             @PathVariable Long investorId) {
//         return holdingService.getHoldingsByInvestor(investorId);
//     }

//     @GetMapping("/{id}")
//     public HoldingRecord getHoldingById(@PathVariable Long id) {
//         return holdingService.getHoldingById(id);
//     }

//     @GetMapping
//     public List<HoldingRecord> getAllHoldings() {
//         return holdingService.getAllHoldings();
//     }
// }


package sbs.rosedev.springFirst.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import sbs.rosedev.springFirst.entity.HoldingRecord;
import sbs.rosedev.springFirst.service.impl.HoldingRecordServiceImpl;

@RestController
@RequestMapping("/api/holdings")
public class HoldingRecordController {

    private final HoldingRecordServiceImpl service;

    public HoldingRecordController(HoldingRecordServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public HoldingRecord recordHolding(
            @RequestBody HoldingRecord holding) {
        return service.recordHolding(holding);
    }

    @GetMapping("/investor/{investorId}")
    public List<HoldingRecord> getHoldingsByInvestor(
            @PathVariable Long investorId) {
        return service.getHoldingsByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public Optional<HoldingRecord> getHoldingById(
            @PathVariable Long id) {
        return service.getHoldingById(id);
    }
}
