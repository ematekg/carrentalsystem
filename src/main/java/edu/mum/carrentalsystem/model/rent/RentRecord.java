package edu.mum.carrentalsystem.model.rent;


import edu.mum.carrentalsystem.model.user.Customer;
import edu.mum.carrentalsystem.model.vehicle.Vehicle;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class RentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private Double rentFee;
    private  boolean paymentStatus;

    public RentRecord(Vehicle vehicle, Customer customer, LocalDate rentDate, LocalDate returnDate, Double rentFee, boolean paymentStatus) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.rentFee = rentFee;
        this.paymentStatus = paymentStatus;
    }

    public RentRecord() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Double getRentFee() {
        return rentFee;
    }

    public void setRentFee(Double rentFee) {
        this.rentFee = rentFee;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
