package edu.mum.carrentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(){
        return "home";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String catagory(){
        return "/vehicle/category";
    }

    @RequestMapping(value = "/carlist", method = RequestMethod.GET)
    public String carList(){
        return "/vehicle/carlist";
    }
}
