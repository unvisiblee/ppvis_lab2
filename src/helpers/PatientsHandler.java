package helpers;

import models.Appointment;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PatientsHandler extends DefaultHandler {
    private ArrayList<Appointment> appointments;
    private Appointment appointment;
    private String currentElement;

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("appointments")) {
            appointments = new ArrayList<Appointment>();
        }
        currentElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("appointment")) {
            appointments.add(appointment);
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("appointment")) {
            appointment = new Appointment();
        }
        if (currentElement.equals("patientName")) {
            appointment.setPatientName(text(ch, start, length));
        }
        if (currentElement.equals("patientSurname")) {
            appointment.setPatientSurname(text(ch, start, length));
        }
        if (currentElement.equals("patientCity")) {
            appointment.setPatientCity(text(ch, start, length));
        }
        if (currentElement.equals("patientStreet")) {
            appointment.setPatientStreet(text(ch, start, length));
        }
        if (currentElement.equals("patientBuildingNumber")) {
            appointment.setPatientBuildingNumber(text(ch, start, length));
        }
        if (currentElement.equals("patientBirthDate")) {
            appointment.setPatientBirthDate(getDate(text(ch, start, length)));
        }
        if (currentElement.equals("doctorName")) {
            appointment.setDoctorName(text(ch, start, length));
        }
        if (currentElement.equals("doctorSurname")) {
            appointment.setDoctorSurname(text(ch, start, length));
        }
        if (currentElement.equals("date")) {
            appointment.setDate(getDate(text(ch, start, length)));
        }
        if (currentElement.equals("diagnosis")) {
            appointment.setDiagnosis(text(ch, start, length));
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
