package controllers;

import views.IndexWindow;
import database.AppointmentsLocalStorage;
import views.NewWindow;

public class AppointmentsController {
    private AppointmentsLocalStorage patients;

    public AppointmentsController() {
        patients = new AppointmentsLocalStorage();
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

    public AppointmentsLocalStorage getPatients() {
        return patients;
    }

    private void updateLocalStorage(String path) {
        patients = new AppointmentsLocalStorage();
        patients.readAllFromFile(path);
    }
}
