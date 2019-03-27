package helpers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import models.Patient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PatientsXMLWriter {
    private String path;

    public PatientsXMLWriter(String path) {
        this.path = path;
    }

    public PatientsXMLWriter() {
        this("src/database/database.xml");
    }

    public void writeAll(ArrayList<Patient> patients) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(path));
            document.getDocumentElement().normalize();
            Node patientsTag = document.getElementsByTagName("patients").item(0);
            removeAll(document, Node.ELEMENT_NODE, "patient");

            SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
            for(Patient patient : patients) {
                Element patientElement = document.createElement("patient");
                patientsTag.appendChild(patientElement);

                Element fullName = document.createElement("fullName");
                fullName.appendChild(document.createTextNode(patient.getFullName()));
                patientElement.appendChild(fullName);

                Element address = document.createElement("address");
                address.appendChild(document.createTextNode(patient.getAddress()));
                patientElement.appendChild(address);

                Element birthDate = document.createElement("birthDate");
                birthDate.appendChild(document.createTextNode(format.format(patient.getBirthDate())));
                patientElement.appendChild(birthDate);

                Element doctorFullName = document.createElement("doctorFullName");
                doctorFullName.appendChild(document.createTextNode(patient.getDoctorFullName()));
                patientElement.appendChild(doctorFullName);

                Element appointmentDate = document.createElement("appointmentDate");
                appointmentDate.appendChild(document.createTextNode(format.format(patient.getAppointmentDate())));
                patientElement.appendChild(appointmentDate);

                Element diagnosis = document.createElement("diagnosis");
                diagnosis.appendChild(document.createTextNode(patient.getDiagnosis()));
                patientElement.appendChild(diagnosis);
            }

//          TODO: normalize
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(path));
            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private void removeAll(Node node, short nodeType, String name) {
        if (node.getNodeType() == nodeType && (name == null || node.getNodeName().equals(name))) {
            node.getParentNode().removeChild(node);
        } else {
            NodeList list = node.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                removeAll(list.item(i), nodeType, name);
            }
        }
    }
}
