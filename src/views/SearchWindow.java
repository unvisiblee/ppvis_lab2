package views;

import controllers.StudentsController;
import models.Parent;
import models.Student;
import database.StudentsLocalStorage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchWindow {
    private StudentsController controller;
    private JFrame searchWindow;
    private TablePartial table;
    private StudentsLocalStorage storage;

    public SearchWindow(StudentsController controller) {
        this.controller = controller;
        searchWindow = new JFrame("Search");
        searchWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchWindow.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        StudentFormPartial form = new StudentFormPartial(controller);
        JPanel panel = form.getPanel();

        JButton closeButton = new JButton("Close");
        JButton searchButton = new JButton("Search");
        closeButton.addActionListener(getCloseButtonListener());
        searchButton.addActionListener(getSearchButtonListener(form));
        panel.add(closeButton);
        panel.add(searchButton);

        table = new TablePartial(controller.getStudents().getRecords());
        contentPane.add(table.getPanel(), BorderLayout.CENTER);
        contentPane.add(panel, BorderLayout.WEST);

        searchWindow.setContentPane(contentPane);
        searchWindow.pack();
    }

    public void show() {
        searchWindow.setVisible(true);
    }

    public void dispose() {
        searchWindow.dispose();
    }

    public void updateTable(ArrayList<Student> students) {
        table.setData(students);
    }

    private ActionListener getCloseButtonListener() {
        return e -> dispose();
    }

    private ActionListener getSearchButtonListener(StudentFormPartial form) {
        return e -> {
            Student student = new Student();
            student.setName(form.getStudentName());
            student.setLastName(form.getStudentLastName());
            student.setSurname(form.getStudentSurname());

            student.setSistersCount(form.getStudentSistersCount().isEmpty() ? 0 : Integer.valueOf(form.getStudentSistersCount()));
            student.setBrothersCount(form.getStudentBrothersCount().isEmpty() ? 0 : Integer.valueOf(form.getStudentBrothersCount()));

            Parent mother = new Parent();
            mother.setName(form.getMotherName());
            mother.setLastName(form.getMotherLastName());
            mother.setSurname(form.getMotherSurname());
            mother.setEarnings(form.getMotherEarnings().isEmpty() ? 0.0 : Double.valueOf(form.getMotherEarnings()));

            student.setMother(mother);

            Parent father = new Parent();
            father.setName(form.getFatherName());
            father.setLastName(form.getFatherLastName());
            father.setSurname(form.getFatherSurname());
            father.setEarnings(form.getFatherEarnings().isEmpty() ? 0.0 : Double.valueOf(form.getFatherEarnings()));

            student.setFather(father);

            updateTable(controller.select(student));
        };
    }
}
