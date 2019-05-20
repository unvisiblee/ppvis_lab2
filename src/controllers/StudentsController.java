package controllers;

import models.Student;
import views.*;
import database.StudentsLocalStorage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StudentsController {
    private StudentsLocalStorage students;
    private IndexWindow indexWindow;

    public StudentsController(StudentsLocalStorage students) {
        this.students = students;
    }

    public void index(IndexWindow window) {
        this.indexWindow = window;
        indexWindow.show();
    }

    public void create(Student student) {
        students.addRecord(student);
        indexWindow.updateTable();
    }

    public List<Student> select(Student student) {
        List<Student> searchResults = students.applyFilters(student);
        return searchResults;
    }

    public void remove(Student student) {
        List<Student> searchResults = students.applyFilters(student);
        List<Student> students = this.students.getRecords();
        students.removeAll(searchResults);
        this.students.setRecords(students);
        new Alert(getRemovedRecordsList(searchResults));
        indexWindow.updateTable();
    }

    public void open(File file) {
        students.setSourceFile(file);
        students.readAll();
        indexWindow.updateTable();
    }

    public void save(File file) {
        students.setSourceFile(file);
        students.saveAll();
    }

    public StudentsLocalStorage getStudents() {
        return students;
    }

    private String getRemovedRecordsList(List<Student> removedRecords) {
        if (removedRecords.size() == 0) {
            return "No matches.";
        }
        String text = removedRecords.size() + " students were removed:\n";
        for (int index = 0; index < removedRecords.size(); index++) {
            Student student = removedRecords.get(index);
            text += student.getFullName() + "\n";
            if (index >= 9) {
                return text + "And " + (removedRecords.size() - index - 1) + " more.";
            }
        }
        return text;
    }
}
