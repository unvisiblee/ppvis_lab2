package database;

import helpers.AppointmentsXMLReader;
import helpers.AppointmentsXMLWriter;
import models.Appointment;

import java.util.ArrayList;

public class AppointmentsLocalStorage {
    private ArrayList<Appointment> appointments;

    public AppointmentsLocalStorage() {
        appointments = new ArrayList<Appointment>();
    }

    public AppointmentsLocalStorage(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void readAllFromFile(String path) {
        appointments = new AppointmentsXMLReader(path).readAll();
    }

    public void readAllFromFile() {
        appointments = new AppointmentsXMLReader().readAll();
    }

    public void commitAllToFile(String path) {
        new AppointmentsXMLWriter(path).writeAll(appointments);
    }

    public void commitAllToFile() {
        new AppointmentsXMLWriter().writeAll(appointments);
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}
