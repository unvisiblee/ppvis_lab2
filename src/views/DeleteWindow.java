package views;

import controllers.StudentsController;
import dataGetters.StudentFormGetter;
import models.Student;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class DeleteWindow {
    private StudentsController controller;
    private JFrame deleteWindow;

    public DeleteWindow(StudentsController controller) {
        this.controller = controller;
        deleteWindow = new JFrame("Delete");
        deleteWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteWindow.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        StudentFormPartial form = new StudentFormPartial(controller);
        JPanel panel = form.getPanel();

        JButton closeButton = new JButton("Close");
        JButton deleteButton = new JButton("Delete");
        closeButton.addActionListener(getCloseButtonListener());
        deleteButton.addActionListener(getSubmitButtonListener(form));
        panel.add(closeButton);
        panel.add(deleteButton);

        contentPane.add(panel);

        deleteWindow.setContentPane(contentPane);
        deleteWindow.pack();
    }

    public void show() {
        deleteWindow.setVisible(true);
    }

    public void dispose() {
        deleteWindow.dispose();
    }

    private ActionListener getCloseButtonListener() {
        return e -> dispose();
    }

    private ActionListener getSubmitButtonListener(StudentFormPartial form) {
        return e -> {

            StudentFormGetter getter = new StudentFormGetter();
            Student student = getter.getData(form);

            List<Student> searchResults = this.controller.students.applyFilters(student);

            controller.remove(searchResults);

            new Alert(getRemovedRecordsList(searchResults));

            IndexWindow indexWindow = new IndexWindow(this.controller);
            indexWindow.updateTable();
            indexWindow.show();
        };
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