package controllers;

import views.IndexWindow;
import database.PatientsLocalStorage;

public class PatientsController {
    private PatientsLocalStorage patients;

    public PatientsController() {
        patients = new PatientsLocalStorage();
        patients.readAllFromFile();
    }

    public void index() {
        new IndexWindow(this).show();
    }

    public PatientsLocalStorage getPatients() {
        return patients;
    }

    private void updateLocalStorage(String path) {
        patients = new PatientsLocalStorage();
        patients.readAllFromFile(path);
    }
}
