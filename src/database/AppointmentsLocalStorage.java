package database;

import helpers.AppointmentsXMLReader;
import helpers.AppointmentsXMLWriter;
import models.Appointment;

import java.io.File;
import java.util.ArrayList;

public class AppointmentsLocalStorage {
    private static final File DEFAULT_SOURCE_FILE = new File("src/database/appointments.xml");
    private ArrayList<Appointment> appointments;
    private File sourceFile;

    public AppointmentsLocalStorage(File sourceFile) {
        this.sourceFile = sourceFile;
        readAll();
    }

    public AppointmentsLocalStorage() {
        this(DEFAULT_SOURCE_FILE);
}

    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void readAll() {
        appointments = new AppointmentsXMLReader(sourceFile).readAll();
    }

    public void commitAll() {
        new AppointmentsXMLWriter(sourceFile).writeAll(appointments);
    }

    public ArrayList<Appointment> getRecords() {
        return appointments;
    }

    public void setRecords(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addRecord(Appointment appointment) {
        appointments.add(appointment);
    }
}
