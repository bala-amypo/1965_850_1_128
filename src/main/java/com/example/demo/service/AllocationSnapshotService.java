package sbs.rosedev.springFirst.service;

import java.util.List;

import sbs.rosedev.springFirst.entity.AllocationSnapshotRecord;

public interface AllocationSnapshotService {

    AllocationSnapshotRecord computeSnapshot(Long investorId);

    AllocationSnapshotRecord getSnapshotById(Long id);

    List<AllocationSnapshotRecord> getAllSnapshots();
}
