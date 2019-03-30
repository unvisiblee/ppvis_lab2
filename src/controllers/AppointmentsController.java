package controllers;

import models.Appointment;
import views.IndexWindow;
import database.AppointmentsLocalStorage;
import views.NewWindow;

import java.util.HashMap;

public class AppointmentsController {
    private AppointmentsLocalStorage appointments;
    private IndexWindow indexWindow;

    public AppointmentsController() {
        appointments = new AppointmentsLocalStorage();
        appointments.readAllFromFile();
    }

    public void index() {
        indexWindow = new IndexWindow(this);
        indexWindow.show();
    }

    public void newRecord() {
        new NewWindow(this).show();
    }

    public void show() {
//        new ShowWindow(this).show();
    }

    public void create(HashMap<String, String> params) {
        Appointment newRecord = new Appointment(params);
        appointments.addAppointment(newRecord);
        indexWindow.updateTable();
    }

    public AppointmentsLocalStorage getAppointments() {
        return appointments;
    }

    private void updateLocalStorage(String path) {
        appointments = new AppointmentsLocalStorage();
        appointments.readAllFromFile(path);
    }
}
