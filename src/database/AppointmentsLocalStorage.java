package database;

import helpers.AppointmentsXMLReader;
import helpers.AppointmentsXMLWriter;
import models.Appointment;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class AppointmentsLocalStorage {
    private static final File DEFAULT_SOURCE_FILE = new File("src/database/appointments.xml");
    private ArrayList<Appointment> records;
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
        records = new AppointmentsXMLReader(sourceFile).readAll();
    }

    public void commitAll() {
        new AppointmentsXMLWriter(sourceFile).writeAll(records);
    }

    public ArrayList<Appointment> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Appointment> appointments) {
        this.records = appointments;
    }

    public void addRecord(Appointment appointment) {
        records.add(appointment);
    }

    public ArrayList<Appointment> applyFilters(HashMap<String, String> params) {
        ArrayList<Appointment> results;
        results = applyPatientNameFilter(params.get("patientName"));
        results = applyPatientSurnameFilter(results, params.get("patientSurname"));
        results = applyPatientCityFilter(results, params.get("patientCity"));
        results = applyPatientStreetFilter(results, params.get("patientStreet"));
        results = applyPatientBuildingNumberFilter(results, params.get("patientBuildingNumber"));
        results = applyPatientBirthDateFilter(results, params.get("patientBirthDate"));
        results = applyDoctorNameFilter(results, params.get("doctorName"));
        results = applyDoctorSurnameFilter(results, params.get("doctorSurname"));
        results = applyDateFilter(results, params.get("date"));
        results = applyDiagnosisFilter(results, params.get("diagnosis"));
        return results;
    }

    private ArrayList<Appointment> applyDiagnosisFilter(ArrayList<Appointment> data, String diagnosis) {
        if (diagnosis.isEmpty()) {
            return data;
        }
        ArrayList<Appointment> results = new ArrayList<Appointment>();
        for(Appointment appointment : data) {
            if (appointment.getDiagnosis().matches(".*" + diagnosis + ".*")) {
                results.add(appointment);
            }
        }
        return results;
    }

    private ArrayList<Appointment> applyDiagnosisFilter(String diagnosis) {
        return applyDiagnosisFilter(records, diagnosis);
    }

    private ArrayList<Appointment> applyDateFilter(ArrayList<Appointment> data, String date) {
        if (date.isEmpty()) {
            return data;
        }
        ArrayList<Appointment> results = new ArrayList<Appointment>();
        for(Appointment appointment : data) {
            if (appointment.getDateString().matches(".*" + date + ".*")) {
                results.add(appointment);
            }
        }
        return results;
    }

    private ArrayList<Appointment> applyDateFilter(String date) {
        return applyDateFilter(records, date);
    }

    private ArrayList<Appointment> applyDoctorSurnameFilter(ArrayList<Appointment> data, String doctorSurname) {
        if (doctorSurname.isEmpty()) {
            return data;
        }
        ArrayList<Appointment> results = new ArrayList<Appointment>();
        for(Appointment appointment : data) {
            if (appointment.getDoctorSurname().matches(".*" + doctorSurname + ".*")) {
                results.add(appointment);
            }
        }
        return results;
    }

    private ArrayList<Appointment> applyDoctorSurnameFilter(String doctorSurname) {
        return applyDoctorSurnameFilter(records, doctorSurname);
    }

    private ArrayList<Appointment> applyDoctorNameFilter(ArrayList<Appointment> data, String doctorName) {
        if (doctorName.isEmpty()) {
            return data;
        }
        ArrayList<Appointment> results = new ArrayList<Appointment>();
        for(Appointment appointment : data) {
            if (appointment.getDoctorName().matches(".*" + doctorName + ".*")) {
                results.add(appointment);
            }
        }
        return results;
    }

    private ArrayList<Appointment> applyDoctorNameFilter(String doctorName) {
        return applyDoctorNameFilter(records, doctorName);
    }

    private ArrayList<Appointment> applyPatientBirthDateFilter(ArrayList<Appointment> data, String patientBirthDate) {
        if (patientBirthDate.isEmpty()) {
            return data;
        }
        ArrayList<Appointment> results = new ArrayList<Appointment>();
        for(Appointment appointment : data) {
            if (appointment.getPatientBirthDateString().matches(".*" + patientBirthDate + ".*")) {
                results.add(appointment);
            }
        }
        return results;
    }

    private ArrayList<Appointment> applyPatientBirthDateFilter(String patientBirthDate) {
        return applyPatientBirthDateFilter(records, patientBirthDate);
    }

    private ArrayList<Appointment> applyPatientBuildingNumberFilter(ArrayList<Appointment> data, String patientBuildingNumber) {
        if (patientBuildingNumber.isEmpty()) {
            return data;
        }
        ArrayList<Appointment> results = new ArrayList<Appointment>();
        for(Appointment appointment : data) {
            if (appointment.getPatientBuildingNumber().matches(".*" + patientBuildingNumber + ".*")) {
                results.add(appointment);
            }
        }
        return results;
    }

    private ArrayList<Appointment> applyPatientBuildingNumberFilter(String patientBuildingNumber) {
        return applyPatientBuildingNumberFilter(records, patientBuildingNumber);
    }

    private ArrayList<Appointment> applyPatientStreetFilter(ArrayList<Appointment> data, String patientStreet) {
        if (patientStreet.isEmpty()) {
            return data;
        }
        ArrayList<Appointment> results = new ArrayList<Appointment>();
        for(Appointment appointment : data) {
            if (appointment.getPatientStreet().matches(".*" + patientStreet + ".*")) {
                results.add(appointment);
            }
        }
        return results;
    }

    private ArrayList<Appointment> applyPatientStreetFilter(String patientStreet) {
        return applyPatientStreetFilter(records, patientStreet);
    }

    private ArrayList<Appointment> applyPatientCityFilter(ArrayList<Appointment> data, String patientCity) {
        if (patientCity.isEmpty()) {
            return data;
        }
        ArrayList<Appointment> results = new ArrayList<Appointment>();
        for(Appointment appointment : data) {
            if (appointment.getPatientCity().matches(".*" + patientCity + ".*")) {
                results.add(appointment);
            }
        }
        return results;
    }

    private ArrayList<Appointment> applyPatientCityFilter(String patientCity) {
        return applyPatientCityFilter(records, patientCity);
    }

    private ArrayList<Appointment> applyPatientSurnameFilter(ArrayList<Appointment> data, String patientSurname) {
        if (patientSurname.isEmpty()) {
            return data;
        }
        ArrayList<Appointment> results = new ArrayList<Appointment>();
        for(Appointment appointment : data) {
            if (appointment.getPatientSurname().matches(".*" + patientSurname + ".*")) {
                results.add(appointment);
            }
        }
        return results;
    }

    private ArrayList<Appointment> applyPatientSurnameFilter(String patientSurname) {
        return applyPatientSurnameFilter(records, patientSurname);
    }

    private ArrayList<Appointment> applyPatientNameFilter(ArrayList<Appointment> data, String patientName) {
        if (patientName.isEmpty()) {
            return data;
        }
        ArrayList<Appointment> results = new ArrayList<Appointment>();
        for(Appointment appointment : data) {
            if (appointment.getPatientName().matches(".*" + patientName + ".*")) {
                results.add(appointment);
            }
        }
        return results;
    }

    private ArrayList<Appointment> applyPatientNameFilter(String patientName) {
        return applyPatientNameFilter(records, patientName);
    }
}
