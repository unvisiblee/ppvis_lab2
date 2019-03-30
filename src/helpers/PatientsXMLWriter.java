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
            Node appointmetsTag = document.getElementsByTagName("appointments").item(0);
            removeAll(document, Node.ELEMENT_NODE, "appointment");

            for(Appointment appointment : appointments) {
                Element appointmentElement = document.createElement("appointment");
                appointmetsTag.appendChild(appointmentElement);

                Element patientElement = document.createElement("patient");

                Element patientName = document.createElement("name");
                patientName.appendChild(document.createTextNode(appointment.getPatientName()));
                patientElement.appendChild(patientName);

                Element patientSurname = document.createElement("surname");
                patientSurname.appendChild(document.createTextNode(appointment.getPatientSurname()));
                patientElement.appendChild(patientSurname);

                Element patientBirthDate = document.createElement("birthDate");
                patientBirthDate.appendChild(document.createTextNode(appointment.getPatientBirthDateString()));
                patientElement.appendChild(patientBirthDate);

                Element addressElement = document.createElement("address");

                Element addressCity = document.createElement("city");
                addressCity.appendChild(document.createTextNode(appointment.getPatientCity()));
                addressElement.appendChild(addressCity);

                Element addressStreet = document.createElement("street");
                addressStreet.appendChild(document.createTextNode(appointment.getPatientStreet()));
                addressElement.appendChild(addressStreet);

                Element addressBuildingNumber = document.createElement("buildingNumber");
                addressBuildingNumber.appendChild(document.createTextNode(appointment.getPatientBuildingNumber()));
                addressElement.appendChild(addressBuildingNumber);

                patientElement.appendChild(addressElement);

                appointmentElement.appendChild(patientElement);

                Element doctorElement = document.createElement("doctor");

                Element doctorName = document.createElement("name");
                doctorName.appendChild(document.createTextNode(appointment.getDoctorName()));
                doctorElement.appendChild(doctorName);

                Element doctorSurname = document.createElement("surname");
                doctorSurname.appendChild(document.createTextNode(appointment.getDoctorSurname()));
                doctorElement.appendChild(doctorSurname);

                appointmentElement.appendChild(doctorElement);

                Element appointmentDate = document.createElement("date");
                appointmentDate.appendChild(document.createTextNode(appointment.getDateString()));
                appointmentElement.appendChild(appointmentDate);

                Element diagnosis = document.createElement("diagnosis");
                diagnosis.appendChild(document.createTextNode(appointment.getDiagnosis()));
                appointmentElement.appendChild(diagnosis);
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
