package controllers;

import models.Student;
import database.StudentsLocalStorage;

import java.io.File;
import java.util.List;

public class StudentsController {
    public StudentsLocalStorage students;

    public StudentsController(StudentsLocalStorage students) {
        this.students = students;
    }


    public void create(Student student) {
        students.addRecord(student);
    }

    public List<Student> select(Student student) {
        List<Student> searchResults = students.applyFilters(student);
        return searchResults;
    }

    public void remove(List<Student> forDeleting) {
        List<Student> students = this.students.getRecords();
        students.removeAll(forDeleting);
        this.students.setRecords(students);
    }

    public void open(File file) {
        students.setSourceFile(file);
        students.readAll();
    }

    public void save(File file) {
        students.setSourceFile(file);
        students.saveAll();
    }

    public StudentsLocalStorage getStudents() {
        return students;
    }
}
