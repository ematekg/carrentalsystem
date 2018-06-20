package edu.mum.carrentalsystem.service.userHandler;

import edu.mum.carrentalsystem.model.user.Customer;
import edu.mum.carrentalsystem.model.user.User;
import edu.mum.carrentalsystem.model.vehicle.VehicleCategory;

import java.util.List;

public interface ICustomerDetailsHandler {
    List<Customer> findAll();
    void deleteById(long id);
    void save(Customer customer);
    Customer findOne(long id);
}
