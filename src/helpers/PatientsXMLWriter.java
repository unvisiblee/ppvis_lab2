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
import models.Appointment;
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

    public void writeAll(ArrayList<Appointment> appointments) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(path));
            document.getDocumentElement().normalize();
            Node patientsTag = document.getElementsByTagName("appointments").item(0);
            removeAll(document, Node.ELEMENT_NODE, "appointment");

            for(Appointment appointment : appointments) {
                Element patientElement = document.createElement("appointment");
                patientsTag.appendChild(patientElement);

                Element name = document.createElement("patientName");
                name.appendChild(document.createTextNode(appointment.getPatientName()));
                patientElement.appendChild(name);

                Element surname = document.createElement("patientSurname");
                surname.appendChild(document.createTextNode(appointment.getPatientSurname()));
                patientElement.appendChild(surname);

                Element city = document.createElement("patientCity");
                city.appendChild(document.createTextNode(appointment.getPatientCity()));
                patientElement.appendChild(city);

                Element street = document.createElement("patientStreet");
                street.appendChild(document.createTextNode(appointment.getPatientStreet()));
                patientElement.appendChild(street);

                Element buildingNumber = document.createElement("patientBuildingNumber");
                buildingNumber.appendChild(document.createTextNode(appointment.getPatientBuildingNumber()));
                patientElement.appendChild(buildingNumber);

                Element birthDate = document.createElement("patientBirthDate");
                birthDate.appendChild(document.createTextNode(appointment.getPatientBirthDateString()));
                patientElement.appendChild(birthDate);

                Element doctorName = document.createElement("doctorName");
                doctorName.appendChild(document.createTextNode(appointment.getDoctorName()));
                patientElement.appendChild(doctorName);

                Element doctorSurname = document.createElement("doctorSurname");
                doctorSurname.appendChild(document.createTextNode(appointment.getDoctorSurname()));
                patientElement.appendChild(doctorSurname);

                Element appointmentDate = document.createElement("date");
                appointmentDate.appendChild(document.createTextNode(appointment.getDateString()));
                patientElement.appendChild(appointmentDate);

                Element diagnosis = document.createElement("diagnosis");
                diagnosis.appendChild(document.createTextNode(appointment.getDiagnosis()));
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
