package edu.mum.carrentalsystem.model.user;

import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import edu.mum.carrentalsystem.model.rent.RentRecord;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends User {

    @OneToOne
    @JoinColumn(name = "payment_id")
    private PaymentInfo paymentInfo;
    @OneToMany(mappedBy = "customer")
    private List<RentRecord> rentrecord;


    public Customer(String firstName, String lastName, Credential credential, Address address, PaymentInfo paymentInfo) {
        super(firstName, lastName, credential, address);
        this.paymentInfo = paymentInfo;
    }

    public Customer() {
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

    public void addRentRecord(RentRecord rentrecord) {
        this.rentrecord.add(rentrecord);
        rentrecord.setCustomer(this);
    }

    public void setRentrecord(List<RentRecord> rentrecord) {
        this.rentrecord = rentrecord;
    }
}
