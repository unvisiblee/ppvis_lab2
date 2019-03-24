package models;

import java.util.Date;

public class Patient {
    private String fullName;
    private String address;
    private Date birthDate;
    private String doctorFullName;
    private Date appointmentDate;
    private String diagnosis;

    public Patient() {
        this("Name unknown", "Address unknown", null, "No doctor", null, "No diagnosis");
    }

    public Patient(String fullName, String address, Date birthDate, String doctorFullName, Date appointmentDate, String diagnosis) {
        this.fullName = fullName;
        this.address = address;
        this.birthDate = birthDate;
        this.doctorFullName = doctorFullName;
        this.appointmentDate = appointmentDate;
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

    public Date getAppointmentDate() {
        return appointmentDate;
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

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
