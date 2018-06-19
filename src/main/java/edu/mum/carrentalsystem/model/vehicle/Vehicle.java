package edu.mum.carrentalsystem.model.vehicle;


import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String model;
    private String make;
    private String year;
    private String url;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private VehicleCatagory category;
    private String description;


    public Vehicle(String model, String make, String year,String url, VehicleCatagory category, String description) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.category = category;
        this.description = description;
        this.url=url;
    }

    public Vehicle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VehicleCatagory getCategory() {
        return category;
    }

    public void setCategory(VehicleCatagory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
