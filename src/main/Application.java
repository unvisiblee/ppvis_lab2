package main;

import main.controller.ProfessorsController;
import main.repository.ProfessorRepository;
import main.views.IndexWindow;

public class Application {
    public static void main(String[] args) {
        IndexWindow indexWindow = new IndexWindow(new ProfessorsController(new ProfessorRepository()));
        indexWindow.show();
    }
}
