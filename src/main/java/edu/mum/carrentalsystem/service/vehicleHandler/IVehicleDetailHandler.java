package edu.mum.carrentalsystem.service.vehicleHandler;

import edu.mum.carrentalsystem.model.vehicle.Vehicle;

import java.util.List;

public interface IVehicleDetailHandler {

    List<Vehicle> findAll();
    void deleteById(long id);
    void save(Vehicle vehicle);
    Vehicle findOne(long id);

}
