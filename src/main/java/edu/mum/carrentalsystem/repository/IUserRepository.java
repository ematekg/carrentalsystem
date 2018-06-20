package edu.mum.carrentalsystem.repository;

import edu.mum.carrentalsystem.model.user.Customer;
import edu.mum.carrentalsystem.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Customer,Long> {

}
