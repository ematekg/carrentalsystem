package edu.mum.carrentalsystem.repository;

import edu.mum.carrentalsystem.model.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address,Long> {
}
