package main.XMLParsing;

import main.entity.Professor;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import main.views.Alert;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProfessorsXMLReader extends DefaultHandler {
    private final ProfessorsHandler handler;
    private SAXParser parser;
    private final File file;

    public ProfessorsXMLReader(File file) {
        this.file = file;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            new Alert("Can't open file");
            e.printStackTrace();
        }
        handler = new ProfessorsHandler();
    }

    public List<Professor> readAll() {
        try {
            parser.parse(file, handler);
        } catch (SAXException | IOException e) {
            new Alert("Can't open file");
            e.printStackTrace();
            return null;
        }
        return handler.getProfessors();
    }
}
