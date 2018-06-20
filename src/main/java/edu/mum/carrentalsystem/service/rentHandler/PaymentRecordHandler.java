package edu.mum.carrentalsystem.service.rentHandler;

import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import edu.mum.carrentalsystem.model.user.Address;
import edu.mum.carrentalsystem.model.user.Customer;
import edu.mum.carrentalsystem.repository.IRentRecordRepository;
import edu.mum.carrentalsystem.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentRecordHandler {

    @Autowired
    IRentRecordRepository rentRecordRepository;

    @Autowired
    IUserRepository iUserRepository;

    Customer customer = new Customer();

//    public RentRecord(Vehicle vehicle, Customer customer, LocalDate rentDate, LocalDate returnDate, Double rentFee, boolean paymentStatus) {

    public void setCustomerInfo(Customer customer){
        this.customer.setFullName(customer.getFullName());
        this.customer.setEmail(customer.getEmail());
        iUserRepository.save(customer);
    }
    public void setCustomerAddress(Address address){
        customer.setAddress(address);
        iUserRepository.save(customer);

    }
    public void setCustomerPaymentInfo(PaymentInfo paymentInfo){
        customer.setPaymentInfo(paymentInfo);
        iUserRepository.save(customer);
    }

}
