package edu.mum.carrentalsystem.service.rentFeeHandler;

import edu.mum.carrentalsystem.model.rent.Promo;
import edu.mum.carrentalsystem.model.rent.RentRecord;
import edu.mum.carrentalsystem.model.user.Customer;
import edu.mum.carrentalsystem.model.vehicle.Vehicle;

public interface IRentRecordBuilder {
    public  RentRecord intialize();
    public Promo buildPromo();
    Vehicle buildVehicle(RentRecord rentRecord);
    public RentRecord getRentRecord(RentRecord rentRecord);
}
