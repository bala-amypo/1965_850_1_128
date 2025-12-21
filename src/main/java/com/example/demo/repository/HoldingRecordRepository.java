package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.HoldingRecord;
 import java.util.Long;

@Repository
public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long>{


}