package controllers;

import views.MainWindow;
import database.PatientsLocalStorage;

public class PatientsController {
    private PatientsLocalStorage patients;

    public PatientsController() {
        patients = new PatientsLocalStorage();
        patients.readAllFromFile();
    }

    public void index() {
        new MainWindow(this).show();
    }

    private void updateLocalStorage(String path) {
        patients = new PatientsLocalStorage();
        patients.readAllFromFile(path);
    }
}
