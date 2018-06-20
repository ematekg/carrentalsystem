package edu.mum.carrentalsystem.service.vehicleHandler;

import edu.mum.carrentalsystem.model.vehicle.Vehicle;
import edu.mum.carrentalsystem.model.vehicle.VehicleCategory;

import java.util.List;

public interface IVehicleCategoryHandler {
    List<VehicleCategory> findAll();
    void deleteById(long id);
    void save(VehicleCategory vehicleCategory);
    VehicleCategory findOne(long id);

}
