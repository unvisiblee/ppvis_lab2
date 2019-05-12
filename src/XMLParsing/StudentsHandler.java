package XMLParsing;

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
    private boolean studentObj;
    private boolean motherObj;
    private boolean fatherObj;


    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("students")) {
            students = new ArrayList<>();
        }

        if (qName.equals("student")) {
            student = new Student();
            studentObj = true;
        }

        if (qName.equals("mother")) {
            mother = new Parent();
            motherObj = true;
        }

        if (qName.equals("father")) {
            father= new Parent();
            fatherObj = true;
        }
        currentElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if (qName.equals("student")) {
            students.add(student);
            studentObj = false;
        }

        if (qName.equals("mother")) {
            student.setMother(mother);
            motherObj= false;
        }

        if (qName.equals("father")) {
            student.setFather(father);
            fatherObj = false;
        }

        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("name") && studentObj) {
            student.setName(text(ch, start, length));
        }

        if (currentElement.equals("surname") && studentObj) {
            student.setSurname(text(ch, start, length));
        }

        if (currentElement.equals("lastName") && studentObj) {
            student.setLastName(text(ch, start, length));
        }

        if (currentElement.equals("sistersCount") && studentObj) {
            student.setSistersCount(parseInt(text(ch, start, length)));
        }

        if (currentElement.equals("brothersCount") && studentObj) {
            student.setBrothersCount(parseInt(text(ch, start, length)));
        }

        if (currentElement.equals("fatherName") && fatherObj) {
            father.setName(text(ch, start, length));
        }

        if (currentElement.equals("fatherSurname") && fatherObj) {
            father.setSurname(text(ch, start, length));
        }

        if (currentElement.equals("fatherLastName") && fatherObj) {
            father.setLastName(text(ch, start, length));
        }

        if (currentElement.equals("fatherEarnings") && fatherObj) {
            father.setEarnings(parseDouble(text(ch, start, length)));
        }

        if (currentElement.equals("motherName") && motherObj) {
            mother.setName(text(ch, start, length));
        }

        if (currentElement.equals("motherSurname") && motherObj) {
            mother.setSurname(text(ch, start, length));
        }

        if (currentElement.equals("motherLastName") && motherObj) {
            mother.setLastName(text(ch, start, length));
        }

        if (currentElement.equals("motherEarnings") && motherObj) {
            mother.setEarnings(parseDouble(text(ch, start, length)));
        }
    }

    private String text(char[] ch, int start, int length) {
        return new String(ch, start, length);
    }
}
