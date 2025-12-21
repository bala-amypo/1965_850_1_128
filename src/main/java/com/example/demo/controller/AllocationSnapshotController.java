package com.example.demo.controller;

import com.example.demo.entity.AllocationSnapshot;
import com.example.demo.service.AllocationSnapshotService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/snapshots")
public class AllocationSnapshotController {

    private final AllocationSnapshotService allocationSnapshotService;

    public AllocationSnapshotController(
            AllocationSnapshotService allocationSnapshotService) {
        this.allocationSnapshotService = allocationSnapshotService;
    }

    // POST /api/snapshots/compute/{investorId} - Compute snapshot
    @PostMapping("/compute/{investorId}")
    public ResponseEntity<AllocationSnapshot> computeSnapshot(
            @PathVariable Long investorId) {

        AllocationSnapshot snapshot =
                allocationSnapshotService.computeSnapshot(investorId);

        return new ResponseEntity<>(snapshot, HttpStatus.CREATED);
    }

    // GET /api/snapshots/investor/{investorId} - Get snapshots by investor
    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<AllocationSnapshot>> getSnapshotsByInvestor(
            @PathVariable Long investorId) {

        return ResponseEntity.ok(
                allocationSnapshotService.getSnapshotsByInvestor(investorId)
        );
    }

    // GET /api/snapshots/{id} - Get snapshot by id
    @GetMapping("/{id}")
    public ResponseEntity<AllocationSnapshot> getSnapshotById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                allocationSnapshotService.getSnapshotById(id)
        );
    }

    // GET /api/snapshots - List all snapshots
    @GetMapping
    public ResponseEntity<List<AllocationSnapshot>> getAllSnapshots() {

        return ResponseEntity.ok(
                allocationSnapshotService.getAllSnapshots()
        );
    }
}
