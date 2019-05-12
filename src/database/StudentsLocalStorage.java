package database;

import XMLParsing.StudentsXMLReader;
import XMLParsing.StudentsXMLWriter;
import models.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StudentsLocalStorage {
    private ArrayList<Student> records = new ArrayList<>();
    private File sourceFile;

    public StudentsLocalStorage() {}

    public boolean isSourceSet() {
        return (sourceFile != null);
    }

    public StudentsLocalStorage setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
        return this;
    }

    public void readAll() {
        records = new StudentsXMLReader(sourceFile).readAll();
        if (records == null) {
            records = new ArrayList<>();
        }
    }

    public void saveAll() {
        new StudentsXMLWriter(sourceFile).writeAll(records);
    }

    public ArrayList<Student> getRecords() {
        return new ArrayList<>(records);
    }

    public void setRecords(ArrayList<Student> students) {
        this.records = students;
    }

    public void addRecord(Student student) {
        records.add(student);
    }

    public ArrayList<Student> applyFilters(Student student){
        Set<Student> results = new HashSet<>();
        applyStudentNameFilter(student.getName()).forEach(e -> results.add(e));
        applyStudentSurnameFilter(student.getSurname()).forEach(e -> results.add(e));
        applyStudentLastNameFilter(student.getLastName()).forEach(e -> results.add(e));
        applyStudentSistersCountFilter(student.getSistersCount()).forEach(e -> results.add(e));
        applyStudentBrothersCountFilter(student.getBrothersCount()).forEach(e -> results.add(e));
        applyStudentMotherEarningsFilter(student.getMotherEarnings()).forEach(e -> results.add(e));
        applyStudentMotherName(student.getMotherName()).forEach(e -> results.add(e));
        applyStudentMotherSurname(student.getMotherSurname()).forEach(e -> results.add(e));
        applyStudentMotherLastName(student.getMotherLastName()).forEach(e -> results.add(e));
        applyStudentFatherEarnings(student.getFatherEarnings()).forEach(e -> results.add(e));
        applyStudentFatherName(student.getFatherName()).forEach(e -> results.add(e));
        applyStudentFatherSurname(student.getFatherSurname()).forEach(e -> results.add(e));
        applyStudentFatherLastName(student.getFatherLastName()).forEach(e -> results.add(e));
        ArrayList<Student> studentArrayList = new ArrayList<>(results);
        return studentArrayList;
    }

    private ArrayList<Student> applyStudentNameFilter(ArrayList<Student> data, String studentName) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getName().equals(studentName)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentNameFilter(String studentName) {
        return applyStudentNameFilter(records, studentName);
    }



    private ArrayList<Student> applyStudentSurnameFilter(ArrayList<Student> data, String studentSurname) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getSurname().equals(studentSurname)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentSurnameFilter(String studentSurname) {
        return applyStudentSurnameFilter(records, studentSurname);
    }

    private ArrayList<Student> applyStudentLastNameFilter(ArrayList<Student> data, String studentLastName) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getLastName().equals(studentLastName)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentLastNameFilter(String studentLastName) {
        return applyStudentLastNameFilter(records, studentLastName);
    }

    private ArrayList<Student> applyStudentSistersCountFilter(ArrayList<Student> data, Integer sistersCount) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getSistersCount().equals(sistersCount)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentSistersCountFilter(Integer sistersCount) {
        return applyStudentSistersCountFilter(records, sistersCount);
    }

    private ArrayList<Student> applyStudentBrothersCountFilter(ArrayList<Student> data, Integer brothersCount) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getBrothersCount().equals(brothersCount)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentBrothersCountFilter(Integer brothersCount) {
        return applyStudentBrothersCountFilter(records, brothersCount);
    }

    private ArrayList<Student> applyStudentMotherEarningsFilter(ArrayList<Student> data, Double motherEarnings) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getMotherEarnings().equals(motherEarnings)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentMotherEarningsFilter(Double motherEarnings) {
        return applyStudentMotherEarningsFilter(records, motherEarnings);
    }

    private ArrayList<Student> applyStudentMotherName(ArrayList<Student> data, String motherName) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getMotherName().equals(motherName)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentMotherName(String motherName) {
        return applyStudentMotherName(records, motherName);
    }


    private ArrayList<Student> applyStudentMotherSurname(ArrayList<Student> data, String motherSurname) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getMotherSurname().equals(motherSurname)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentMotherSurname(String motherSurname) {
        return applyStudentMotherSurname(records, motherSurname);
    }

    private ArrayList<Student> applyStudentMotherLastName(ArrayList<Student> data, String motherLastName) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getMotherLastName().equals(motherLastName)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentMotherLastName(String motherLastName) {
        return applyStudentMotherLastName(records, motherLastName);
    }

    private ArrayList<Student> applyStudentFatherEarnings(ArrayList<Student> data, Double fatherEarnings) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getFatherEarnings().equals(fatherEarnings)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentFatherEarnings(Double fatherEarnings) {
        return applyStudentFatherEarnings(records, fatherEarnings);
    }

    private ArrayList<Student> applyStudentFatherName(ArrayList<Student> data, String fatherName) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getFatherName().equals(fatherName)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentFatherName(String fatherName) {
        return applyStudentFatherName(records, fatherName);
    }


    private ArrayList<Student> applyStudentFatherSurname(ArrayList<Student> data, String fatherSurname) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getFatherSurname().equals(fatherSurname)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentFatherSurname(String fatherSurname) {
        return applyStudentFatherSurname(records, fatherSurname);
    }

    private ArrayList<Student> applyStudentFatherLastName(ArrayList<Student> data, String fatherLastName) {
        ArrayList<Student> results = new ArrayList<>();
        for(Student student : data) {
            if (student.getFatherLastName().equals(fatherLastName)) {
                results.add(student);
            }
        }
        return results;
    }

    private ArrayList<Student> applyStudentFatherLastName(String fatherLastName) {
        return applyStudentFatherLastName(records, fatherLastName);
    }

}
