package helpers;

import views.Alert;
import models.Student;

import java.io.*;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class StudentsXMLWriter {
    private File file;
    private static final String DEFAULT_STRUCTURE = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
            "<students>\n</students>";

    public StudentsXMLWriter(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(DEFAULT_STRUCTURE);
            fileWriter.close();
            this.file = file;
        } catch (IOException e) {
            new Alert("Cannot write to file.\nInsure it's in right format and you have write permissions.");
            e.printStackTrace();
        }
    }

    public void writeAll(ArrayList<Student> students) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            Node studentsTag = document.getElementsByTagName("students").item(0);
            removeAll(document, Node.ELEMENT_NODE, "students");

            for(Student student: students) {
                Element studentElement = document.createElement("student");
                studentsTag.appendChild(studentElement);

                Element studentName = document.createElement("name");
                studentName.appendChild(document.createTextNode(student.getName()));
                studentElement.appendChild(studentName);

                Element studentSurname = document.createElement("surname");
                studentSurname.appendChild(document.createTextNode(student.getSurname()));
                studentElement.appendChild(studentSurname);

                Element studentLastName = document.createElement("lastName");
                studentLastName.appendChild(document.createTextNode(student.getLastName()));
                studentElement.appendChild(studentLastName);

                Element studentSistersCount = document.createElement("sistersCount");
                studentSistersCount.appendChild(document.createTextNode(student.getSistersCount().toString()));
                studentElement.appendChild(studentSistersCount);

                Element studentBrothersCount = document.createElement("brothersCount");
                studentBrothersCount.appendChild(document.createTextNode(student.getBrothersCount().toString()));
                studentElement.appendChild(studentBrothersCount);

                Element motherElement = document.createElement("mother");

                Element motherName = document.createElement("motherName");
                motherName.appendChild(document.createTextNode(student.getMotherName()));
                motherElement.appendChild(motherName);

                Element motherSurname = document.createElement("motherSurname");
                motherSurname.appendChild(document.createTextNode(student.getMotherSurname()));
                motherElement.appendChild(motherSurname);

                Element motherLastName = document.createElement("motherLastName");
                motherLastName.appendChild(document.createTextNode(student.getMotherLastName()));
                motherElement.appendChild(motherLastName);

                Element motherEarnings = document.createElement("motherEarnings");
                motherEarnings.appendChild(document.createTextNode(student.getMotherEarnings().toString()));
                motherElement.appendChild(motherName);

                Element fatherElement = document.createElement("father");

                Element fatherName = document.createElement("fatherName");
                fatherName.appendChild(document.createTextNode(student.getFatherName()));
                fatherElement.appendChild(fatherName);

                Element fatherSurname = document.createElement("fatherSurname");
                fatherSurname.appendChild(document.createTextNode(student.getFatherSurname()));
                fatherElement.appendChild(fatherSurname);

                Element fatherLastName = document.createElement("fatherLastName");
                fatherLastName.appendChild(document.createTextNode(student.getFatherLastName()));
                motherElement.appendChild(motherLastName);

                Element fatherEarnings = document.createElement("fatherEarnings");
                fatherEarnings.appendChild(document.createTextNode(student.getFatherEarnings().toString()));
                fatherElement.appendChild(fatherName);

                studentElement.appendChild(motherElement);

                studentElement.appendChild(fatherElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            new Alert("Cannot write to file.\nInsure it's in right format and you have write permissions.");
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
