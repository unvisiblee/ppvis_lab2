package models;

import java.util.Date;

public class Patient {
    private String fullName;
    private String address;
    private Date birthDate;
    private String doctorFullName;
    private Date appointmenthDate;
    private String diagnosis;

    public Patient() {
        this("Name unknown", "Address unknown", null, "No doctor", null, "No diagnosis");
    }

    public Patient(String fullName, String address, Date birthDate, String doctorFullName, Date appointmenthDate, String diagnosis) {
        this.fullName = fullName;
        this.address = address;
        this.birthDate = birthDate;
        this.doctorFullName = doctorFullName;
        this.appointmenthDate = appointmenthDate;
        this.diagnosis = diagnosis;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public Date getAppointmenthDate() {
        return appointmenthDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public void setAppointmenthDate(Date appointmenthDate) {
        this.appointmenthDate = appointmenthDate;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
