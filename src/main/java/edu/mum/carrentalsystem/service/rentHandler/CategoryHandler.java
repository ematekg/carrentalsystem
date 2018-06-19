package edu.mum.carrentalsystem.service.rentHandler;

import edu.mum.carrentalsystem.model.vehicle.Vehicle;
import edu.mum.carrentalsystem.model.vehicle.VehicleCategory;
import edu.mum.carrentalsystem.repository.IVehicleRepository;
import edu.mum.carrentalsystem.service.cachememory.VehicleListCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryHandler {

    @Autowired
    IVehicleRepository vehicleRepository;



    public List<Vehicle> getAllVehicles() {
//       return vehicleRepository.findAll();
        return new VehicleListCache().getAllCarList();
    }

    public List<Vehicle> getVehiclesByCategory(VehicleCategory vehicleCategory) {

        System.out.println(vehicleCategory.getName());
        return new VehicleListCache().getAllCarList();
//        return vehicleCategory.getVehicleList();

    }

}
