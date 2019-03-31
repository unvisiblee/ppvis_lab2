package controllers;

import models.Appointment;
import views.IndexWindow;
import database.AppointmentsLocalStorage;
import views.NewWindow;
import views.SearchWindow;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class AppointmentsController {
    private AppointmentsLocalStorage appointments;
    private IndexWindow indexWindow;
    private SearchWindow searchWindow;

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
        searchWindow = new SearchWindow(this);
        searchWindow.show();
    }

    public void remove() {

    }

    public void create(HashMap<String, String> params) {
        Appointment newRecord = new Appointment(params);
        appointments.addRecord(newRecord);
        indexWindow.updateTable();
    }

    public void select(HashMap<String, String> params) {
        ArrayList<Appointment> searchResults = appointments.applyFilters(params);
        searchWindow.updateTable(searchResults);
    }

    public void delete() {

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

    public AppointmentsLocalStorage getAppointments() {
        return appointments;
    }
}
