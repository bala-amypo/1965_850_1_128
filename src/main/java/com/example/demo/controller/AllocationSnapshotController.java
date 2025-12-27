// package sbs.rosedev.springFirst.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import sbs.rosedev.springFirst.entity.AllocationSnapshotRecord;
// import sbs.rosedev.springFirst.services.AllocationSnapshotServiceImpl;

// @RestController
// @RequestMapping("/api/snapshots")
// public class AllocationSnapshotController {

//     private final AllocationSnapshotServiceImpl snapshotService;

//     public AllocationSnapshotController(
//             AllocationSnapshotServiceImpl snapshotService) {
//         this.snapshotService = snapshotService;
//     }

//     @PostMapping("/compute/{investorId}")
//     public AllocationSnapshotRecord computeSnapshot(
//             @PathVariable Long investorId) {
//         return snapshotService.computeSnapshot(investorId);
//     }

//     @GetMapping("/investor/{investorId}")
//     public AllocationSnapshotRecord getSnapshotsByInvestor(
//             @PathVariable Long investorId) {
//         return snapshotService.getSnapshotsByInvestor(investorId);
//     }

//     @GetMapping("/{id}")
//     public AllocationSnapshotRecord getSnapshotById(
//             @PathVariable Long id) {
//         return snapshotService.getSnapshotById(id);
//     }

//     @GetMapping
//     public List<AllocationSnapshotRecord> getAllSnapshots() {
//         return snapshotService.getAllSnapshots();
//     }
// }


package com.demo.springFirst.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.demo.springFirst.entity.AllocationSnapshotRecord;
import com.demo.springFirst.service.impl.AllocationSnapshotServiceImpl;

@RestController
@RequestMapping("/api/snapshots")
public class AllocationSnapshotController {

    private final AllocationSnapshotServiceImpl service;

    public AllocationSnapshotController(AllocationSnapshotServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/compute/{investorId}")
    public AllocationSnapshotRecord computeSnapshot(
            @PathVariable Long investorId) {
        return service.computeSnapshot(investorId);
    }

    @GetMapping("/{id}")
    public AllocationSnapshotRecord getSnapshotById(
            @PathVariable Long id) {
        return service.getSnapshotById(id);
    }

    @GetMapping
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return service.getAllSnapshots();
    }
}
