package edu.mum.carrentalsystem.repository;

import edu.mum.carrentalsystem.model.rent.RentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentRecordRepository  extends JpaRepository<RentRecord, Long> {
}
