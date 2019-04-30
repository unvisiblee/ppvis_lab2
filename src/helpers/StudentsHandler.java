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
    private Parent mother;
    private Parent father;
    private String currentElement;
    private boolean isStudent;
    private boolean isMother;
    private boolean isFather;


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
            isStudent = true;
        }

        if (qName.equals("mother")) {
            mother = new Parent();
            isMother = true;
        }

        if (qName.equals("father")) {
            father= new Parent();
            isFather = true;
        }
        currentElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("student")) {
            students.add(student);
            isStudent = false;
        }

        if (qName.equals("mother")) {
            student.setMother(mother);
            isMother= false;
        }

        if (qName.equals("father")) {
            student.setFather(father);
            isFather = false;
        }

        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("name") && isStudent) {
            student.setName(text(ch, start, length));
        }

        if (currentElement.equals("surname") && isStudent) {
            student.setSurname(text(ch, start, length));
        }

        if (currentElement.equals("lastName") && isStudent) {
            student.setLastname(text(ch, start, length));
        }

        if (currentElement.equals("sistersCount") && isStudent) {
            student.setSistersCount(parseInt(text(ch, start, length)));
        }

        if (currentElement.equals("brothersCount") && isStudent) {
            student.setBrothersCount(parseInt(text(ch, start, length)));
        }

        if (currentElement.equals("fatherName") && isFather) {
            father.setName(text(ch, start, length));
        }

        if (currentElement.equals("fatherSurname") && isFather) {
            father.setSurname(text(ch, start, length));
        }

        if (currentElement.equals("fatherLastName") && isFather) {
            father.setLastName(text(ch, start, length));
        }

        if (currentElement.equals("fatherEarnings") && isFather) {
            father.setEarnings(parseDouble(text(ch, start, length)));
        }

        if (currentElement.equals("motherName") && isMother) {
            mother.setName(text(ch, start, length));
        }

        if (currentElement.equals("motherSurname") && isMother) {
            mother.setSurname(text(ch, start, length));
        }

        if (currentElement.equals("motherLastName") && isMother) {
            mother.setLastName(text(ch, start, length));
        }

        if (currentElement.equals("motherEarnings") && isMother) {
            mother.setEarnings(parseDouble(text(ch, start, length)));
        }
    }

    private String text(char[] ch, int start, int length) {
        return new String(ch, start, length);
    }
}
