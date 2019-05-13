package views;

import controllers.StudentsController;
import dataGetters.StudentFormGetter;
import models.Parent;
import models.Student;

import javax.swing.*;
import java.awt.event.ActionListener;

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

            controller.remove(student);
        };
    }
}