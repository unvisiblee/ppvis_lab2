package database;

import helpers.PatientsXMLReader;
import helpers.PatientsXMLWriter;
import models.Appointment;

import java.util.ArrayList;

public class PatientsLocalStorage {
    private ArrayList<Appointment> appointments;

    public PatientsLocalStorage() {
        appointments = new ArrayList<Appointment>();
    }

    public PatientsLocalStorage(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void readAllFromFile(String path) {
        appointments = new PatientsXMLReader(path).readAll();
    }

    public void readAllFromFile() {
        appointments = new PatientsXMLReader().readAll();
    }

    public void commitAllToFile(String path) {
        new PatientsXMLWriter(path).writeAll(appointments);
    }

    public void commitAllToFile() {
        new PatientsXMLWriter().writeAll(appointments);
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
}
