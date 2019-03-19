package controllers;

import views.MainWindow;
import helpers.XMLReader; //

public class PatientsController {
    public void index() {
        // new XMLReader().getAllPatients();
        new MainWindow(this).show();
    }
}
