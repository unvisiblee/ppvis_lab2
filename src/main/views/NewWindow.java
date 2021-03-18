package main.views;

import main.form.ProfessorForm;
import main.controller.ProfessorsController;

import java.awt.event.ActionListener;
import javax.swing.*;

public class NewWindow {
    private final ProfessorsController controller;
    private final JFrame newWindow;
    private final IndexWindow indexWindow;

    public NewWindow(ProfessorsController controller, IndexWindow indexWindow) {
        this.indexWindow = indexWindow;
        this.controller = controller;
        newWindow = new JFrame("New professor");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        ProfessorForm form = new ProfessorForm();
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

    private ActionListener getSubmitButtonListener(ProfessorForm form) {
        return e -> {
            controller.createFromForm(form);

            indexWindow.updateTable();
            indexWindow.show();
            newWindow.setVisible(false);
        };
    }
}
