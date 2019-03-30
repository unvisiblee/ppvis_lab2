package helpers;

import java.io.File;
import java.io.IOException;
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

            for(Patient patient : patients) {
                Element patientElement = document.createElement("patient");
                patientsTag.appendChild(patientElement);

                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(patient.getName()));
                patientElement.appendChild(name);

                Element surname = document.createElement("surname");
                surname.appendChild(document.createTextNode(patient.getSurname()));
                patientElement.appendChild(surname);

                Element city = document.createElement("city");
                city.appendChild(document.createTextNode(patient.getCity()));
                patientElement.appendChild(city);

                Element street = document.createElement("street");
                street.appendChild(document.createTextNode(patient.getStreet()));
                patientElement.appendChild(street);

                Element buildingNumber = document.createElement("buildingNumber");
                buildingNumber.appendChild(document.createTextNode(patient.getBuildingNumber()));
                patientElement.appendChild(buildingNumber);

                Element birthDate = document.createElement("birthDate");
                birthDate.appendChild(document.createTextNode(patient.getBirthDateString()));
                patientElement.appendChild(birthDate);

                Element doctorFullName = document.createElement("doctorFullName");
                doctorFullName.appendChild(document.createTextNode(patient.getDoctorFullName()));
                patientElement.appendChild(doctorFullName);

                Element appointmentDate = document.createElement("appointmentDate");
                appointmentDate.appendChild(document.createTextNode(patient.getAppointmentDateString()));
                patientElement.appendChild(appointmentDate);

                Element diagnosis = document.createElement("diagnosis");
                diagnosis.appendChild(document.createTextNode(patient.getDiagnosis()));
                patientElement.appendChild(diagnosis);
            }

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
