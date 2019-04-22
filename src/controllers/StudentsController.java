package controllers;

import models.Student;
import views.*;
import database.StudentsLocalStorage;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentsController {
    private StudentsLocalStorage students;
    private IndexWindow indexWindow;
    private SearchWindow searchWindow;

    public StudentsController(StudentsLocalStorage students) {
        this.students = students;
    }

    public void index(IndexWindow window) {
        this.indexWindow = window;
        indexWindow.show();
    }

    public void newRecord() {
        new NewWindow(this).show();
    }

    public void search() {
        searchWindow = new SearchWindow(this);
        searchWindow.show();
    }

    public void delete() {
        new DeleteWindow(this).show();
    }

    public void create(HashMap<String, String> params) {
        Student newRecord = new Student(params);
        students.addRecord(newRecord);
        indexWindow.updateTable();
    }

    public void select(HashMap<String, String> params) {
        ArrayList<Student> searchResults = students.applyFilters(params);
        searchWindow.updateTable(searchResults);
    }

    public void remove(HashMap<String, String> params) {
        ArrayList<Student> searchResults = students.applyFilters(params);
        ArrayList<Student> students = this.students.getRecords();
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
        students.commitAll();
    }

    public void save() {
        if (students.isSourceSet()) {
            students.commitAll();
        } else {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();;
                open(file);
            }
        }
    }

    public StudentsLocalStorage getStudents() {
        return students;
    }

    private String getRemovedRecordsList(ArrayList<Student> removedRecords) {
        if (removedRecords.size() == 0) {
            return "No records removed.";
        }
        String text = new String(removedRecords.size() + " students removed:\n");
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
