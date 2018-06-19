package edu.mum.carrentalsystem.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends User {

    public Admin(String firstName, String lastName, Credential credential, Address address) {
        super(firstName, lastName, credential, address);
    }

    public Admin() {
    }
}
