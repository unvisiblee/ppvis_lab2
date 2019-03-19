package helpers;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLReader {
    private Document document;

    public XMLReader(String path) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(new File(path));
    }

    public XMLReader() throws ParserConfigurationException {
        this("../database/database.xml");
    }

    public void getAllPatients() {
        NodeList patients = document.getDocumentElement().getElementsByTagName("patient");
        for (int i = 0; i < patients.getLength(); i++) {
            Node patient = patients.item(i);
            String id = patient.getAttributes().getNamedItem("id").getNodeValue();

            patient.getChildNodes();
            // getTextContent()
        }
    }
}
