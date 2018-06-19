package edu.mum.carrentalsystem.model.vehicle;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Vehicle> vehicleList;

    public VehicleCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public VehicleCategory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
    public void addVehicle(Vehicle vehcile) {
        this.vehicleList.add(vehcile);
        vehcile.setCategory(this);
    }
}
