package edu.mum.carrentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/home")
    public String index(){
        return "home";
    }

    @RequestMapping("vehicle/catagory")
    public String catagory(){
        return "vehicle/catagory";
    }
}
