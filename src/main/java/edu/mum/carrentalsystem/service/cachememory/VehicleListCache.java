package edu.mum.carrentalsystem.service.cachememory;

import edu.mum.carrentalsystem.model.vehicle.Vehicle;
import edu.mum.carrentalsystem.model.vehicle.VehicleCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VehicleListCache {

    Map<Long, Vehicle> vehicleMap = null;

//    public Vehicle(String model, String make, String year,String url, String description) {

    public VehicleListCache(){
        vehicleMap = new HashMap<>();

        for(Long i = Long.valueOf(1); i<25; i++){
            String model = "Camry";
            String make = "Toyota";
            String year = "1999";
            String url = "toyotacamry";
            String description = "bla bla bla bla bla BlaBlaCar is an online marketplace for carpooling. " +
                    "Its website and mobile apps connect drivers and p" +
                    "assengers willing to travel together between cities and share the cost of the journey";
            vehicleMap.put(i, new Vehicle(model,make, year, url, description));
        }
    }

    public List<Vehicle> getAllCarList(){
        return vehicleMap.entrySet().stream().map(map -> map.getValue()).collect(Collectors.toList());
    }
}
