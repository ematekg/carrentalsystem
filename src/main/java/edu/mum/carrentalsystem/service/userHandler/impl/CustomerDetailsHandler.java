package edu.mum.carrentalsystem.service.userHandler.impl;

import edu.mum.carrentalsystem.model.user.Customer;
import edu.mum.carrentalsystem.model.user.User;
import edu.mum.carrentalsystem.repository.IUserRepository;
import edu.mum.carrentalsystem.service.userHandler.ICustomerDetailsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailsHandler  implements ICustomerDetailsHandler {

  @Autowired
 private IUserRepository userRepository;

    @Override
    public List<Customer> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public void save(Customer customer) {
        userRepository.save(customer);

    }

    @Override
    public Customer findOne(long id) {
        return userRepository.getOne(id);
    }
}
