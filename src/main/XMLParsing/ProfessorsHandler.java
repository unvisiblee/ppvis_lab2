package main.XMLParsing;

import main.entity.Professor;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ProfessorsHandler extends DefaultHandler {
    private List<Professor> professors;
    private Professor professor;
    private String currentElement;
    private Boolean professorObj;

    public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) {
        if (qName.equals("professors")) {
            professors = new ArrayList<>();
        }

        if (qName.equals("professor")) {
            professor = new Professor();
            professorObj = true;
        }

        currentElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if (qName.equals("professor")) {
            professors.add(professor);
            professorObj = false;
        }

        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentElement.equals("name") && professorObj) {
            professor.setName(getText(ch, start, length));
        }

        if (currentElement.equals("lastName") && professorObj) {
            professor.setLastName(getText(ch, start, length));
        }

        if (currentElement.equals("patronymic") && professorObj) {
            professor.setPatronymic(getText(ch, start, length));
        }

        if (currentElement.equals("faculty") && professorObj) {
            professor.setFaculty(getText(ch, start, length));
        }

        if (currentElement.equals("department") && professorObj) {
            professor.setDepartment(getText(ch, start, length));
        }

        if (currentElement.equals("academicRank") && professorObj) {
            professor.setAcademicRank(getText(ch, start, length));
        }

        if (currentElement.equals("degree") && professorObj) {
            professor.setDegree(getText(ch, start, length));
        }

        if (currentElement.equals("experience") && professorObj) {
            professor.setExperience(parseInt(getText(ch, start, length)));
        }

    }

    private String getText(char[] ch, int start, int length) {
        return new String(ch, start, length);
    }

    public List<Professor> getProfessors() {
        return professors;
    }
}
