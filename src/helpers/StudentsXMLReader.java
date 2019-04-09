package helpers;

import models.Student;
import views.Alert;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.SAXException;

public class StudentsXMLReader {
    private StudentsHandler handler;
    private SAXParser parser;
    private File file;

    public StudentsXMLReader(File file) {
        this.file = file;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            new Alert("Cannot open file.\nEnsure it's in right format and you have read permissions.");
            e.printStackTrace();
        }
        handler = new StudentsHandler();
    }

    public ArrayList<Student> readAll() {
        try {
            parser.parse(file, handler);
        } catch (SAXException | IOException e) {
            new Alert("Cannot open file.\nEnsure it's in right format and you have read permissions.");
            e.printStackTrace();
            return null;
        }
        return handler.getStudents();
    }
}
