package edu.mum.carrentalsystem.controller;

import edu.mum.carrentalsystem.model.vehicle.Vehicle;
import edu.mum.carrentalsystem.model.vehicle.VehicleCategory;
import edu.mum.carrentalsystem.service.cachememory.VehicleCatagoryCache;
import edu.mum.carrentalsystem.service.rentHandler.CategoryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    CategoryHandler categoryHandler;

    VehicleCatagoryCache cache = new VehicleCatagoryCache();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index() {
        return "home";
    }


    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String catagory(Model model) {
        List<VehicleCategory> vehicleCategoryList = cache.getAllCategory();
        model.addAttribute("vehicleCategory", vehicleCategoryList);
        return "vehicle/category";
    }

    @RequestMapping(value = "/carlist", method = RequestMethod.GET)
    public String viewAllCarList(Model model) {
        List<Vehicle> vehicleList = categoryHandler.getAllVehicles();
        model.addAttribute("allvehicles", vehicleList);
        return "vehicle/carlist";
    }


    @RequestMapping(value = "/carlist/{vehicleCategory}", method = RequestMethod.GET)
    public String viewCarsOnCategory(VehicleCategory vehicleCategory, Model model) {
        List<Vehicle> vehicleList = categoryHandler.getVehiclesByCategory(vehicleCategory);
        System.out.println(vehicleList);
        model.addAttribute("vehiclelist", vehicleList);
        return "vehicle/carlist";
    }

}
