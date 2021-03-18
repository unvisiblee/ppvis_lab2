package main.XMLParsing;

import main.entity.Professor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import main.views.Alert;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProfessorsXMLWriter {
    private File file;
    private static final String DEFAULT_STRUCTURE = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
            "<professors>\n</professors>";

    public ProfessorsXMLWriter(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(DEFAULT_STRUCTURE);
            fileWriter.close();
            this.file = file;
        } catch (IOException e) {
            new Alert("Can't write to file");
            e.printStackTrace();
        }
    }

    public void writeAll(List<Professor> professors) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            Node professorTag = document.getElementsByTagName("professors").item(0);
            removeAll(document, Node.ELEMENT_NODE, "professor");

            for(Professor professor: professors) {
                Element professorElement = document.createElement("professor");
                professorTag.appendChild(professorElement);

                Element professorName = document.createElement("name");
                professorName.appendChild(document.createTextNode(professor.getName()));
                professorElement.appendChild(professorName);

                Element professorLastName = document.createElement("lastName");
                professorLastName.appendChild(document.createTextNode(professor.getLastName()));
                professorElement.appendChild(professorLastName);

                Element professorPatronymic = document.createElement("patronymic");
                professorPatronymic.appendChild(document.createTextNode(professor.getPatronymic()));
                professorElement.appendChild(professorPatronymic);

                Element professorFaculty = document.createElement("faculty");
                professorFaculty.appendChild(document.createTextNode(professor.getFaculty()));
                professorElement.appendChild(professorFaculty);

                Element professorDepartment = document.createElement("department");
                professorDepartment.appendChild(document.createTextNode(professor.getDepartment()));
                professorElement.appendChild(professorDepartment);

                Element professorAcademicRank = document.createElement("academicRank");
                professorAcademicRank.appendChild(document.createTextNode(professor.getAcademicRank()));
                professorElement.appendChild(professorAcademicRank);

                Element professorDegree = document.createElement("degree");
                professorDegree.appendChild(document.createTextNode(professor.getDegree()));
                professorElement.appendChild(professorDegree);

                Element professorExperience = document.createElement("experience");
                professorExperience.appendChild(document.createTextNode(String.valueOf(professor.getExperience())));
                professorElement.appendChild(professorExperience);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            new Alert("Can't");
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
