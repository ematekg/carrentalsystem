package edu.mum.carrentalsystem.model.user;

import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import edu.mum.carrentalsystem.model.rent.RentRecord;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends User {

    private  String email;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private PaymentInfo paymentInfo;
    @OneToMany(mappedBy = "customer")
    private List<RentRecord> rentrecord;

    public Customer(String fullName, Address address, String email, PaymentInfo paymentInfo) {
        super(fullName, address);
        this.email = email;
        this.paymentInfo = paymentInfo;
    }

    public Customer(String fullName,  String email) {
        super(fullName,null);
        this.email = email;
    }

    public Customer() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public List<RentRecord> getRentrecord() {
        return rentrecord;
    }

    public void setRentrecord(List<RentRecord> rentrecord) {
        this.rentrecord = rentrecord;
    }



    public void addRentRecord(RentRecord rentrecord) {
        this.rentrecord.add(rentrecord);
        rentrecord.setCustomer(this);
    }
}
