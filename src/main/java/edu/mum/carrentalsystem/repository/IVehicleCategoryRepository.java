package edu.mum.carrentalsystem.repository;

import edu.mum.carrentalsystem.model.vehicle.Vehicle;
import edu.mum.carrentalsystem.model.vehicle.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleCategoryRepository extends JpaRepository<VehicleCategory,Long> {
}
