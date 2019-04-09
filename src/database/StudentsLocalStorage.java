package database;

import helpers.StudentsXMLReader;
import helpers.StudentsXMLWriter;
import models.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentsLocalStorage {
    private ArrayList<Student> records = new ArrayList<Student>();
    private File sourceFile;

    public StudentsLocalStorage(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public StudentsLocalStorage() {}

    public boolean isSourceSet() {
        return (sourceFile != null);
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public StudentsLocalStorage setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
        return this;
    }

    public void readAll() {
        records = new StudentsXMLReader(sourceFile).readAll();
        if (records == null) {
            records = new ArrayList<Student>();
        }
    }

    public void commitAll() {
        new StudentsXMLWriter(sourceFile).writeAll(records);
    }

    public ArrayList<Student> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Student> students) {
        this.records = students;
    }

    public void addRecord(Student student) {
        records.add(student);
    }

    public ArrayList<Student> applyFilters(HashMap<String, String> params) {
        ArrayList results = new ArrayList();
        results.add(applyStudentNameFilter(params.get("studentName")));
        results.add(applyStudentSurnameFilter(params.get("studentSurname")));
        results.add(applyStudentLastNameFilter(params.get("studentLastName")));
        results.add(applyStudentSistersCountFilter(params.get("studentSistersCount")));
        results.add(applyStudentBrothersCountFilter(params.get("studentBrothersCount")));
        results.add(applyStudentMotherEarningsFilter(params.get("studentMotherEarnings")));
        results.add(applyStudentMotherName(params.get("studentMotherName")));
        results.add(applyStudentMotherSurname(params.get("studentMotherSurname")));
        results.add(applyStudentMotherLastName(params.get("studentMotherLastName")));
        results.add(applyStudentFatherEarnings(params.get("studentFatherEarnings")));
        results.add(applyStudentFatherName(params.get("studentFatherName")));
        results.add(applyStudentFatherSurname(params.get("studentFatherSurname")));
        results.add(applyStudentFatherLastName(params.get("studentFatherLastName")));
        return results;
    }

    private ArrayList<Student> applyStudentNameFilter(ArrayList<Student> data, String studentName) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getName().matches(".*" + studentName + ".*")) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentNameFilter(String studentName) {
        return applyStudentNameFilter(records, studentName);
    }



    private ArrayList<Student> applyStudentSurnameFilter(ArrayList<Student> data, String studentSurname) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getSurname().matches(".*" + studentSurname + ".*")) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentSurnameFilter(String studentSurname) {
        return applyStudentSurnameFilter(records, studentSurname);
    }

    private ArrayList<Student> applyStudentLastNameFilter(ArrayList<Student> data, String studentLastName) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getLastName().matches(".*" + studentLastName + ".*")) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentLastNameFilter(String studentLastName) {
        return applyStudentLastNameFilter(records, studentLastName);
    }

    private ArrayList<Student> applyStudentSistersCountFilter(ArrayList<Student> data, String sistersCount) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getSistersCount().toString().matches(sistersCount)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentSistersCountFilter(String sistersCount) {
        return applyStudentSistersCountFilter(records, sistersCount);
    }

    private ArrayList<Student> applyStudentBrothersCountFilter(ArrayList<Student> data, String brothersCount) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getBrothersCount().toString().matches(brothersCount)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentBrothersCountFilter(String brothersCount) {
        return applyStudentBrothersCountFilter(records, brothersCount);
    }

    private ArrayList<Student> applyStudentMotherEarningsFilter(ArrayList<Student> data, String motherEarnings) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getMotherEarnings().toString().matches(motherEarnings)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentMotherEarningsFilter(String motherEarnings) {
        return applyStudentMotherEarningsFilter(records, motherEarnings);
    }

    private ArrayList<Student> applyStudentMotherName(ArrayList<Student> data, String motherName) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getMotherName().matches(".*" + motherName + ".*")) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentMotherName(String motherName) {
        return applyStudentMotherName(records, motherName);
    }


    private ArrayList<Student> applyStudentMotherSurname(ArrayList<Student> data, String motherSurname) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getMotherSurname().matches(".*" + motherSurname + ".*")) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentMotherSurname(String motherSurname) {
        return applyStudentMotherSurname(records, motherSurname);
    }

    private ArrayList<Student> applyStudentMotherLastName(ArrayList<Student> data, String motherLastName) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getMotherLastName().matches(".*" + motherLastName+ ".*")) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentMotherLastName(String motherLastName) {
        return applyStudentMotherLastName(records, motherLastName);
    }

    private ArrayList<Student> applyStudentFatherEarnings(ArrayList<Student> data, String fatherEarnings) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getFatherEarnings().toString().matches(fatherEarnings)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentFatherEarnings(String fatherEarnings) {
        return applyStudentFatherEarnings(records, fatherEarnings);
    }

    private ArrayList<Student> applyStudentFatherName(ArrayList<Student> data, String fatherName) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getFatherName().matches(".*" + fatherName + ".*")) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentFatherName(String fatherName) {
        return applyStudentFatherName(records, fatherName);
    }


    private ArrayList<Student> applyStudentFatherSurname(ArrayList<Student> data, String fatherSurname) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getFatherSurname().matches(".*" + fatherSurname + ".*")) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentFatherSurname(String fatherSurname) {
        return applyStudentFatherSurname(records, fatherSurname);
    }

    private ArrayList<Student> applyStudentFatherLastName(ArrayList<Student> data, String fatherLastName) {
        ArrayList<Student> results = new ArrayList<Student>();
        for(Student student : data) {
            if (student.getFatherLastName().matches(".*" + fatherLastName+ ".*")) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentFatherLastName(String fatherLastName) {
        return applyStudentFatherLastName(records, fatherLastName);
    }

}
