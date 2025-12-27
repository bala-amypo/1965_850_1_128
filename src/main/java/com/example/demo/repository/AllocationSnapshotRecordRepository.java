package sbs.rosedev.springFirst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sbs.rosedev.springFirst.entity.AllocationSnapshotRecord;

public interface AllocationSnapshotRecordRepository extends JpaRepository<AllocationSnapshotRecord, Long> {
}