package helpers;

import models.Appointment;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PatientsXMLReader {
    private PatientsHandler handler;
    private SAXParser parser;
    private String path;

    public PatientsXMLReader() {
        this("src/database/database.xml");
    }

    public PatientsXMLReader(String path) {
        this.path = path;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        handler = new PatientsHandler();
    }

    public ArrayList<Appointment> readAll() {
        try {
            parser.parse(new File(path), handler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return handler.getAppointments();
    }
}
