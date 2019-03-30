package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient {
    private String name;
    private String surname;
    private String city;
    private String street;
    private String buildingNumber;
    private Date birthDate;
    private String doctorFullName;
    private Date appointmentDate;
    private String diagnosis;

    public Patient() {
        this("", "", "", "", "", null, "", null, "");
    }

    public Patient(String name, String surname, String city, String street, String buildingNumber, Date birthDate, String doctorFullName, Date appointmentDate, String diagnosis) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.birthDate = birthDate;
        this.doctorFullName = doctorFullName;
        this.appointmentDate = appointmentDate;
        this.diagnosis = diagnosis;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return city + ", " + street + " " + buildingNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthDateString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        return format.format(getBirthDate());
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDateString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        return format.format(getAppointmentDate());
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
