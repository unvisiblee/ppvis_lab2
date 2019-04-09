package helpers;

import models.Student;
import models.Parent;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class StudentsHandler extends DefaultHandler {
    private ArrayList<Student> students;
    private Student student;
    private Parent parent;
    private String currentElement;
    private boolean isStudent;
    private boolean isParent;


    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("students")) {
            students = new ArrayList<Student>();
        }

        if (qName.equals("student")) {
            student = new Student();
            isStudent= true;
        }

        if (qName.equals("parent")) {
            parent = new Parent();
            isParent= true;
        }
        currentElement = qName;
    }

//    STOP HEER
    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("student")) {
            students.add(student);
            isStudent = false;
        }

        if (qName.equals("parent")) {
//            isStudent.setParent(parent);
            isParent = false;
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("studentName") && isStudent) {
            student.setName(text(ch, start, length));
        }

        if (currentElement.equals("studentSurname") && isStudent) {
            student.setSurname(text(ch, start, length));
        }

        if (currentElement.equals("studentLastName") && isStudent) {
            student.setLastname(text(ch, start, length));
        }

        if (currentElement.equals("studentSistersCount") && isStudent) {
            student.setSistersCount(parseInt(text(ch, start, length)));
        }

        if (currentElement.equals("studentBrothersCount") && isStudent) {
            student.setBrothersCount(parseInt(text(ch, start, length)));
        }

        if (currentElement.equals("fatherName") && isParent) {
            student.setFatherName(text(ch, start, length));
        }

        if (currentElement.equals("fatherSurname") && isParent) {
            student.setFatherSurname(text(ch, start, length));
        }

        if (currentElement.equals("fatherLastName") && isParent) {
            student.setFatherLastName(text(ch, start, length));
        }

        if (currentElement.equals("fatherEarnings") && isParent) {
            student.setFatherEarnings(parseDouble(text(ch, start, length)));
        }

        if (currentElement.equals("motherName") && isParent) {
            student.setMotherName(text(ch, start, length));
        }

        if (currentElement.equals("motherSurname") && isParent) {
            student.setMotherSurname(text(ch, start, length));
        }

        if (currentElement.equals("motherLastName") && isParent) {
            student.setMotherLastName(text(ch, start, length));
        }

        if (currentElement.equals("motherEarnings") && isParent) {
            student.setMotherEarnings(parseDouble(text(ch, start, length)));
        }
    }

    private String text(char[] ch, int start, int length) {
        return new String(ch, start, length);
    }
}
