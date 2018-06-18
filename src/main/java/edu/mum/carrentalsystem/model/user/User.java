package edu.mum.carrentalsystem.model.user;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long userId;
    protected String firstName;
    protected  String lastName;
    @OneToOne
    @JoinColumn(name = "credential_id")
    protected Credential credential;
    @OneToOne
    @JoinColumn(name = "address_id")
    protected Address address;

    public User(String firstName, String lastName, Credential credential, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credential = credential;
        this.address = address;
    }

    public User() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
