package edu.mum.carrentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReturnController {

    @RequestMapping("/customer")
    public String customerList()
    {
        return "admin/shared";
    }

    @RequestMapping("/list")
    public String vehicleList(Model model){

        model.addAttribute("vehicles");

        return "admin/vehicleList";
    }
}
