package edu.mum.carrentalsystem.controller;


import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import edu.mum.carrentalsystem.model.user.Address;
import edu.mum.carrentalsystem.model.user.Customer;
import edu.mum.carrentalsystem.service.rentHandler.PaymentRecordHandler;
import edu.mum.carrentalsystem.service.vehicleHandler.IVehicleDetailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rent")
public class RentController {


    @Autowired
    IVehicleDetailHandler vehicleDetailHandler;

    @Autowired
    PaymentRecordHandler paymentRecordHandler;

    @RequestMapping(value = "/checkout/{id}", method = RequestMethod.GET)
    public ModelAndView checkout(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject( vehicleDetailHandler.findOne(id));
        modelAndView.setViewName("/rent/customerInfo");
        return modelAndView;
    }

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public String submitCustomerInfo(@ModelAttribute Customer customer){
        paymentRecordHandler.setCustomerInfo(customer);
        return "/rent/addressform";
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public String submitAddressForm(Model model, @ModelAttribute Address address){
        model.addAttribute("payment",new PaymentInfo());
        paymentRecordHandler.setCustomerAddress(address);
        return "rent/paymentinfo";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String submitpaymentForm(@ModelAttribute("payment") PaymentInfo paymentInfo, Model model){
        paymentRecordHandler.setCustomerPaymentInfo(paymentInfo);
        return "rent/successfulmessage";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public String savePayment(@ModelAttribute("payment") PaymentInfo paymentInfo, Model model){

        paymentRecordHandler.setCustomerPaymentInfo(paymentInfo);

        return "rent/successfulmessage";
    }
}
