package controllers;

import views.IndexWindow;
import database.PatientsLocalStorage;
import views.NewWindow;

public class PatientsController {
    private PatientsLocalStorage patients;

    public PatientsController() {
        patients = new PatientsLocalStorage();
        patients.readAllFromFile();
    }

    public void index() {
        new IndexWindow(this).show();
    }

    public void newRecord() {
        new NewWindow(this).show();
    }

    public void show() {
//        new ShowWindow(this).show();
    }

    public void create() {

    }

    public PatientsLocalStorage getPatients() {
        return patients;
    }

    private void updateLocalStorage(String path) {
        patients = new PatientsLocalStorage();
        patients.readAllFromFile(path);
    }
}
