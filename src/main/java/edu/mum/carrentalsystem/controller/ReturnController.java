package edu.mum.carrentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReturnController {

    @RequestMapping("/customer")
    public String customerList(){
        return "admin/shared";
    }
}
