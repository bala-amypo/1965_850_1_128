package com.example.demo.controller;

import com.example.demo.service.AllocationSnapshotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllocationSnapshotController {

    private final AllocationSnapshotService allocationSnapshotService;

    public AllocationSnapshotController(AllocationSnapshotService allocationSnapshotService) {
        this.allocationSnapshotService = allocationSnapshotService;
    }

    @GetMapping("/allocation/snapshot")
    public String getSnapshot() {
        return allocationSnapshotService.getSnapshot();
    }
}
