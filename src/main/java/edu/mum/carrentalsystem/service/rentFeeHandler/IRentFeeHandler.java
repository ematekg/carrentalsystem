package edu.mum.carrentalsystem.service.rentFeeHandler;



import edu.mum.carrentalsystem.model.rent.RentRecord;

import java.util.List;

public interface IRentFeeHandler  {
    List<RentRecord> findAll();
    void deleteById(long id);
    void save(RentRecord rentRecord);
    RentRecord findOne(long id);
}
