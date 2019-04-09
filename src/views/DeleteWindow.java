package views;

import controllers.StudentsController;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
            controller.remove(params);
        };
    }
}
