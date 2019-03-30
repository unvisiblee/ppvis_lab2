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

    public ArrayList<Patient> getPatients() {
        return patients;
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
        if (currentElement.equals("name")) {
            patient.setName(text(ch, start, length));
        }
        if (currentElement.equals("surname")) {
            patient.setSurname(text(ch, start, length));
        }
        if (currentElement.equals("city")) {
            patient.setCity(text(ch, start, length));
        }
        if (currentElement.equals("street")) {
            patient.setStreet(text(ch, start, length));
        }
        if (currentElement.equals("buildingNumber")) {
            patient.setBuildingNumber(text(ch, start, length));
        }
        if (currentElement.equals("birthDate")) {
            patient.setBirthDate(getDate(text(ch, start, length)));
        }
        if (currentElement.equals("doctorFullName")) {
            patient.setDoctorFullName(text(ch, start, length));
        }
        if (currentElement.equals("appointmentDate")) {
            patient.setAppointmentDate(getDate(text(ch, start, length)));
        }
        if (currentElement.equals("diagnosis")) {
            patient.setDiagnosis(text(ch, start, length));
        }
    }

    private String text(char[] ch, int start, int length) {
        return new String(ch, start, length);
    }

    private Date getDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
