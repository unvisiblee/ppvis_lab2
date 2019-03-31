package helpers;

import models.Appointment;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AppointmentsXMLReader {
    private AppointmentsHandler handler;
    private SAXParser parser;
    private File file;

    public AppointmentsXMLReader(File file) {
        this.file = file;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        handler = new AppointmentsHandler();
    }

    public ArrayList<Appointment> readAll() {
        try {
            parser.parse(file, handler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return handler.getAppointments();
    }
}
