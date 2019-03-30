package models;

import java.util.Date;

public class Patient {
    private String name;
    private String surname;
    private Address address;
    private Date birthDate;

    public Patient(String name, String surname, Date birthDate, Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.birthDate = birthDate;
    }

    public Patient() {
        this("", "", new Date(), new Address());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public Address getAddress() {
        return address;
    }

    public String getFullAddress() {
        return address.getFullAddress();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
