package edu.mum.carrentalsystem.service.rentHandler;

import edu.mum.carrentalsystem.model.vehicle.Vehicle;
import edu.mum.carrentalsystem.model.vehicle.VehicleCategory;
import edu.mum.carrentalsystem.repository.IVehicleCategoryRepository;
import edu.mum.carrentalsystem.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryHandler {

    @Autowired
    IVehicleRepository vehicleRepository;

    @Autowired
    IVehicleCategoryRepository vehicleCategoryRepository;


    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<VehicleCategory> getAllVehicleCategories() {
        return  vehicleCategoryRepository.findAll();
    }

    public List<Vehicle> getVehiclesByCategory(long id) {

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        return vehicleList.stream().filter(vehicle -> vehicle.getCategory().getId() == id).collect(Collectors.toList());
    }

}
