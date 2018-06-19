package edu.mum.carrentalsystem.service.cachememory;

import edu.mum.carrentalsystem.model.vehicle.VehicleCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VehicleCatagoryCache {

   static Map<Long, VehicleCategory> vehicleCategoryMap = null;

    public VehicleCatagoryCache() {
        vehicleCategoryMap = new HashMap<>();
        String description = "\n" +
                "Car\n" +
                "401 Gridlock.jpg\n" +
                "Modern cars and trucks driving on an expressway in Ontario, Canada.\n" +
                "Classification\tVehicle\n" +
                "Industry\tVarious\n" +
                "Application\tTransportation\n" +
                "Fuel source\tGasoline, diesel, natural gas, electric, hydrogen, solar, vegetable oil\n" +
                "Powered\tYes\n" +
                "Self-propelled\tYes\n" +
                "Wheels\t3–4\n" +
                "Axles\t2\n" +
                "Inventor\tKarl Benz[1]\n" +
                "A car (or automobile) is a wheeled motor vehicle used for transportation. Most definitions of car say they run primarily on roads, seat one to eight people, have four tires, and mainly transport people rather than goods";
        String imgUrl = "http://www.americanluxuryautorental.com/wp-content/uploads/2017/05/Easy-Car-Rental-in-Miami-285x190.jpg";

        for (long i = 100; i< 110; i++){
            String name = "Sport Car " + i;
            vehicleCategoryMap.put(i, new VehicleCategory(name,description,imgUrl));
        }
    }

    public List<VehicleCategory> getAllCategory(){
        return vehicleCategoryMap.entrySet().stream().map(map -> map.getValue()).collect(Collectors.toList());
    }
}
