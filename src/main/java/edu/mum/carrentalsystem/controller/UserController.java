package edu.mum.carrentalsystem.controller;

import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import edu.mum.carrentalsystem.model.rent.RentRecord;
import edu.mum.carrentalsystem.model.user.*;
import edu.mum.carrentalsystem.model.vehicle.Vehicle;
import edu.mum.carrentalsystem.service.userHandler.ICustomerDetailsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private ICustomerDetailsHandler customerDetailsHandler;


    @RequestMapping("/customerlist")
    public String listCustomers(Model model){

        model.addAttribute("customers",customerDetailsHandler.findAll());
        return "admin/customerList";

    }


    @RequestMapping("/return/{id}")
    public String addVehicle(Model model, @PathVariable long id){
        Customer customer=customerDetailsHandler.findOne(id);

        RentRecord rentRecord=customer.getRentrecord().get(0);

        model.addAttribute("customer",customer);
        model.addAttribute("rentrecord",rentRecord);

        return "admin/return";

    }




}
