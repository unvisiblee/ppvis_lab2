package views;

import controllers.StudentsController;
import dataGetters.StudentFormGetter;
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
    private StudentFormGetter getter;

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

            StudentFormGetter getter = new StudentFormGetter();
            Student student = getter.getData(form);
            updateTable(controller.select(student));
        };
    }
}
