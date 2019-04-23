package views;

import controllers.StudentsController;
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
            Student student = new Student();
            student.setName(form.getStudentName());
            student.setLastname(form.getStudentLastName());
            student.setSurname(form.getStudentSurname());

            student.setSistersCount(Integer.valueOf(form.getStudentSistersCount()));
            student.setBrothersCount(Integer.valueOf(form.getStudentBrothersCount()));

            Parent mother = new Parent();
            mother.setName(form.getMotherName());
            mother.setLastName(form.getMotherLastName());
            mother.setSurname(form.getMotherSurname());
            mother.setEarnings(Double.valueOf(form.getMotherEarnings()));

            student.setMother(mother);

            Parent father = new Parent();
            father.setName(form.getFatherName());
            father.setLastName(form.getFatherLastName());
            father.setSurname(form.getFatherSurname());
            father.setEarnings(Double.valueOf(form.getFatherEarnings()));

            student.setFather(father);

            controller.create(student);
        };
    }
}
