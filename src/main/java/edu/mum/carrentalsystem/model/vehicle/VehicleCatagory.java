package edu.mum.carrentalsystem.model.vehicle;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleCatagory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Vehicle> vehicleList;
  private  String catImg_url;
    public VehicleCatagory(String name, String description,String catImg_url;) {
        this.name = name;
        this.description = description;
    }

    public VehicleCatagory() {
    }

    public void setCatImg_url(String catImg_url) {
        this.catImg_url = catImg_url;
    }

    public String getCatImg_url() {
        return catImg_url;
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
