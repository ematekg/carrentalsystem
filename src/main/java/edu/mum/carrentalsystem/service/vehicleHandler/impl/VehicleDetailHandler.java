package edu.mum.carrentalsystem.service.vehicleHandler.impl;

import edu.mum.carrentalsystem.model.vehicle.Vehicle;
import edu.mum.carrentalsystem.service.vehicleHandler.IVehicleDetailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleDetailHandler implements IVehicleDetailHandler {

    @Autowired
     private IVehicleDetailHandler vehicleDetailHandler;


    @Override
    public List<Vehicle> findAll() {
        return vehicleDetailHandler.findAll();
    }

    @Override
    public void deleteById(long id) {

        vehicleDetailHandler.deleteById(id);

    }

    @Override
    public void save(Vehicle vehicle) {

        vehicleDetailHandler.save(vehicle);

    }

    @Override
    public Vehicle findOne(long id) {
        return vehicleDetailHandler.findOne(id);
    }
}
