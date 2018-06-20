package edu.mum.carrentalsystem.controller;

import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import edu.mum.carrentalsystem.model.user.*;
import edu.mum.carrentalsystem.service.userHandler.ICustomerDetailsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private ICustomerDetailsHandler customerDetailsHandler;

//    User customer;
//    List<Customer> customers;


   // (String cardNumber, LocalDate expireDate, int cvv)

    @PostConstruct
    public void init() {


//        PaymentInfo paymentInfo =new PaymentInfo("5124526716",LocalDate.of(2012,06,01),534);
//
//
//        Address address=new Address("100 N 4th street","fairfield","IOwa",52557);
//        customer=new Customer("John Doe",address,"johndoe@gmail.com",paymentInfo);
//        Customer c=(Customer)customer;
//        customers.add(c);

    }

    @RequestMapping("/customerlist")
    public String listCustomers(Model model){

        model.addAttribute("customers",customerDetailsHandler.findAll());
        return "admin/customerList";

    }




}
