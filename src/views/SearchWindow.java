package views;

import controllers.StudentsController;
import models.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchWindow {
    private StudentsController controller;
    private JFrame searchWindow;
    private TablePartial table;

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
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("studentName", form.getStudentName());
            params.put("studentSurname", form.getStudentSurname());
            params.put("studentLastName", form.getStudentLastName());
            params.put("studentSistersCount", form.getStudentSistersCount());
            params.put("studentBrothersCount", form.getStudentBrothersCount());
            params.put("motherName", form.getMotherName());
            params.put("motherSurname", form.getMotherSurname());
            params.put("motherLastName", form.getMotherLastName());
            params.put("motherEarnings", form.getMotherEarnings());
            params.put("fatherName", form.getFatherName());
            params.put("fatherSurname", form.getFatherSurname());
            params.put("fatherLastName", form.getFatherLastName());
            params.put("fatherEarnings", form.getFatherEarnings());
            controller.select(params);
        };
    }
}
