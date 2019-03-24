package helpers;

import models.Patient;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PatientsHandler extends DefaultHandler {
    private ArrayList<Patient> patients;
    private Patient patient;
    private String currentElement;
    private SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing...");
    }

    @Override
    public void endDocument() {
        System.out.println("Finish parsing.");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("patients")) {
            patients = new ArrayList<Patient>();
        }
        currentElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("patient")) {
            patients.add(patient);
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("patient")) {
            patient = new Patient();
        }
        if (currentElement.equals("fullName")) {
            patient.setFullName(text(ch, start, length));
        }
        if (currentElement.equals("address")) {
            patient.setAddress(text(ch, start, length));
        }
        if (currentElement.equals("birthDate")) {
            Date date = null;
            try {
                date = format.parse(text(ch, start, length));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            patient.setBirthDate(date);
        }
        if (currentElement.equals("doctorFullName")) {
            patient.setDoctorFullName(text(ch, start, length));
        }
        if (currentElement.equals("appointmenthDate")) {
            Date date = null;
            try {
                date = format.parse(text(ch, start, length));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            patient.setAppointmenthDate(date);
        }
        if (currentElement.equals("diagnosis")) {
            patient.setDiagnosis(text(ch, start, length));
        }
    }

    private String text(char[] ch, int start, int length) {
        return new String(ch, start, length);
    }
}
