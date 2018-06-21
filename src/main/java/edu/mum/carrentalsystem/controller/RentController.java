package edu.mum.carrentalsystem.controller;


import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import edu.mum.carrentalsystem.model.rent.RentRecord;
import edu.mum.carrentalsystem.model.user.Address;
import edu.mum.carrentalsystem.model.user.Customer;
import edu.mum.carrentalsystem.service.PaymentInfoValidatorStrategy.GeneralCardVerification;
import edu.mum.carrentalsystem.service.rentHandler.PaymentRecordHandler;
import edu.mum.carrentalsystem.service.vehicleHandler.IVehicleDetailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/rent")
public class RentController {


    @Autowired
    IVehicleDetailHandler vehicleDetailHandler;

    @Autowired
    PaymentRecordHandler paymentRecordHandler;

    @Autowired
    GeneralCardVerification generalCardVerification;

    @RequestMapping(value = "/checkout/{id}", method = RequestMethod.GET)
    public String checkout(@PathVariable long id, Model model){
        paymentRecordHandler.selectVehicle(id);
        model.addAttribute("rentRecord",new RentRecord());
        return "/rent/customerInfo";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public String submitCustomerInfo(@ModelAttribute Customer customer, Model model
    ,@RequestParam("pickUpDate") String pick,@RequestParam("dropOffDate") String drop){
        LocalDate pickupdate =LocalDate.parse(pick);
        LocalDate returndate =LocalDate.parse(drop);
        //LocalDate pickupdate = LocalDate.now();
       // LocalDate returndate = pickupdate.plusDays(15);
        paymentRecordHandler.setCustomerInfo(customer,pickupdate,returndate);



       boolean validDate = paymentRecordHandler.dateVerifier(pickupdate, returndate);
       if(validDate){
           System.out.println("please Enter a valid date");
       }
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
    public String savePayment(@ModelAttribute("payment") PaymentInfo paymentInfo){

        boolean isValidCard = generalCardVerification.isValid(paymentInfo);

        if(isValidCard){
            System.out.println("this card is not valid");
        }else {
            System.out.println("this card is valid");
        }
        paymentRecordHandler.setCustomerPaymentInfo(paymentInfo);
        return "rent/successfulmessage";
        //return "rent/successfulmessage";
    }

}
