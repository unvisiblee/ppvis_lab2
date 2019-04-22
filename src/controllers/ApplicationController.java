package controllers;

import database.StudentsLocalStorage;
import views.IndexWindow;

public class ApplicationController {
    public static void main(String[] args) {
        StudentsLocalStorage students = new StudentsLocalStorage();
        StudentsController controller = new StudentsController(students);
        IndexWindow indexWindow = new IndexWindow(controller);
        controller.index(indexWindow);
    }
}
