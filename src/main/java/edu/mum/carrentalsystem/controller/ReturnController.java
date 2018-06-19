package edu.mum.carrentalsystem.controller;

import edu.mum.carrentalsystem.model.user.*;
import edu.mum.carrentalsystem.model.vehicle.Vehicle;
import edu.mum.carrentalsystem.model.vehicle.VehicleCatagory;
import edu.mum.carrentalsystem.service.vehicleHandler.IVehicleDetailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller
public class ReturnController {



   @Autowired
    private IVehicleDetailHandler vehicleDetailHandler;
     private User user;

    @PostConstruct
    public void init() {
        Credential credential=new Credential("admin","1234");
        credential.setRole(Role.ADMIN);

        Address address=new Address("100 N 4th street","fairfield","IOwa",52557);
        user=new Admin("John","Doe",credential,address);

    }

    @RequestMapping("/welcome")
    public String customerList()
    {
        return "admin/shared";
    }


    @RequestMapping("/admin")
    public String login(Model model)
    {
        model.addAttribute("credential",new Credential());
        return "admin/login";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute("credential") Credential credential)
    {
        credential.setRole(Role.ADMIN);

        Credential credInDb=user.getCredential();
        if(credInDb.equals(credential)){
            return "redirect:/welcome";
        }
        return "admin/login";
    }

    @RequestMapping("/list")
    public String vehicleList(Model model){

        model.addAttribute("vehicles",vehicleDetailHandler.findAll());

        return "admin/vehicleList";
    }

    @RequestMapping("/add")
    public String addVehicle(Model model){
        model.addAttribute("vehicle",new Vehicle());
       // model.addAttribute("category",new VehicleCatagory("SUV","4 Doors"));
        return "admin/addVehicle";

    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String createVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle
            , BindingResult result,Model model){
        if(result.hasErrors()){

            model.addAttribute("errors",result.getAllErrors());

            return "redirect:/add";

        }
       // vehicle.setCategory(cat);
        vehicleDetailHandler.save(vehicle);


        return "redirect:/list";


    }
}
