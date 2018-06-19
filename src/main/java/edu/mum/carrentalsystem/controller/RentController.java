package edu.mum.carrentalsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rent")
public class RentController {

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout(){
        return "/rent/customerInfo";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(HttpServletRequest request){

        return "rent/successfulmessage";
    }

}
