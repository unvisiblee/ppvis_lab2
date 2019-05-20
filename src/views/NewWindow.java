package views;

import controllers.StudentsController;
import dataGetters.StudentFormGetter;
import models.Parent;
import models.Student;

import java.awt.event.ActionListener;
import javax.swing.*;

public class NewWindow {
    private StudentsController controller;
    private JFrame newWindow;

    public NewWindow(StudentsController controller) {
        this.controller = controller;
        newWindow = new JFrame("New student");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        StudentFormPartial form = new StudentFormPartial(controller);
        JPanel panel = form.getPanel();

        JButton closeButton = new JButton("Close");
        JButton submitButton = new JButton("Submit");
        closeButton.addActionListener(getCloseButtonListener());
        submitButton.addActionListener(getSubmitButtonListener(form));
        panel.add(closeButton);
        panel.add(submitButton);

        contentPane.add(panel);

        newWindow.setContentPane(contentPane);
        newWindow.pack();
    }

    public void show() {
        newWindow.setVisible(true);
    }

    public void dispose() {
        newWindow.dispose();
    }

    private ActionListener getCloseButtonListener() {
        return e -> dispose();
    }

    private ActionListener getSubmitButtonListener(StudentFormPartial form) {
        return e -> {
            StudentFormGetter getter = new StudentFormGetter();
            Student student = getter.getData(form);

            controller.create(student);

            IndexWindow indexWindow = new IndexWindow(this.controller);
            indexWindow.updateTable();
            indexWindow.show();
        };
    }
}
