package edu.mum.carrentalsystem.repository;

import edu.mum.carrentalsystem.model.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle,Long> {
}
