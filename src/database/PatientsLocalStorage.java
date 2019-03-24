package database;

import helpers.PatientsXMLReader;
import models.Patient;

import java.util.ArrayList;

public class PatientsLocalStorage {
    private ArrayList<Patient> patients;

    public PatientsLocalStorage() {
        patients = new ArrayList<Patient>();
    }

    public PatientsLocalStorage(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void readAllFromFile(String path) {
        patients = new PatientsXMLReader(path).readAll();
    }

    public void readAllFromFile() {
        patients = new PatientsXMLReader().readAll();
    }

    public void commitAllToFile(String path) {

    }

    public void commitAllToFile() {

    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }
}
