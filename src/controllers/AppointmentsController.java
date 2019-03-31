package controllers;

import models.Appointment;
import views.IndexWindow;
import database.AppointmentsLocalStorage;
import views.NewWindow;
import views.SearchWindow;

import java.io.File;
import java.util.HashMap;

public class AppointmentsController {
    private AppointmentsLocalStorage appointments;
    private IndexWindow indexWindow;

    public AppointmentsController() {
        appointments = new AppointmentsLocalStorage();
    }

    public void index() {
        indexWindow = new IndexWindow(this);
        indexWindow.show();
    }

    public void newRecord() {
        new NewWindow(this).show();
    }

    public void search() {
        new SearchWindow(this).show();
    }

    public void create(HashMap<String, String> params) {
        Appointment newRecord = new Appointment(params);
        appointments.addRecord(newRecord);
        indexWindow.updateTable();
    }

    public AppointmentsLocalStorage getAppointments() {
        return appointments;
    }

    public void open(File file) {
        appointments.setSourceFile(file);
        appointments.readAll();
        indexWindow.updateTable();
    }

    public void save(File file) {
        appointments.setSourceFile(file);
        appointments.commitAll();
    }

    public void save() {
        appointments.commitAll();
    }
}
