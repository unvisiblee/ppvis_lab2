package views;

import controllers.PatientsController;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NewWindow {
    private PatientsController controller;
    private JFrame mainWindow;

    public NewWindow(PatientsController controller) {
        this.controller = controller;
        mainWindow = new JFrame("Hospital");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
    }

    public void show() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(15, 1, 10, 10));
        mainWindow.setContentPane(contentPane);

        JLabel fullNameLabel = new JLabel("Full name:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel birthDateLabel = new JLabel("Birth date:");
        JLabel doctorFullNameLabel = new JLabel("Doctor's full name:");
        JLabel appointmentDateLabel = new JLabel("appointment date:");
        JLabel diagnosisLabel = new JLabel("Diagnosis:");
        JTextField fullNameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField birthDateField = new JTextField(20);
        JTextField doctorFullNameField = new JTextField(20);
        JTextField appointmentDateField = new JTextField(20);
        JTextField diagnosisField = new JTextField(20);
        JButton submitButton = new JButton("Create");

        contentPane.add(fullNameLabel);
        contentPane.add(fullNameField);
        contentPane.add(addressLabel);
        contentPane.add(addressField);
        contentPane.add(birthDateLabel);
        contentPane.add(birthDateField);
        contentPane.add(doctorFullNameLabel);
        contentPane.add(doctorFullNameField);
        contentPane.add(appointmentDateLabel);
        contentPane.add(appointmentDateField);
        contentPane.add(diagnosisLabel);
        contentPane.add(diagnosisField);
        contentPane.add(submitButton);

        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    private ActionListener getAddButtonListener() {
        return e -> {
            controller.create();
        };
    }
}
