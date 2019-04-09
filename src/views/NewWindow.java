package views;

import controllers.StudentsController;

import java.awt.event.ActionListener;
import java.util.HashMap;
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
            controller.create(params);
        };
    }
}
