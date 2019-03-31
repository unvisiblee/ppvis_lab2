package views;

import controllers.AppointmentsController;
import helpers.DatePickerLabelFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Properties;
import javax.swing.*;

public class NewWindow {
    private AppointmentsController controller;
    private JFrame newWindow;
    private JTextField patientNameField;
    private JTextField patientSurnameField;
    private JTextField patientCityField;
    private JTextField patientStreetField;
    private JTextField patientBuildingNumberField;
    private JDatePickerImpl patientBirthDateField;
    private JTextField doctorNameField;
    private JTextField doctorSurnameField;
    private JDatePickerImpl dateField;
    private JTextField diagnosisField;

    public NewWindow(AppointmentsController controller) {
        this.controller = controller;
        newWindow = new JFrame("New appointment");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new GridLayout(11, 2, 5, 5));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel patientNameLabel = new JLabel("Patient's name:");
        JLabel patientSurnameLabel = new JLabel("Patient's surname:");
        JLabel patientCityLabel = new JLabel("Patient's city:");
        JLabel patientStreetLabel = new JLabel("Patient's street:");
        JLabel patientBuildingNumberLabel = new JLabel("Patient's building number:");
        JLabel birthDateLabel = new JLabel("Patient's birth date:");
        JLabel doctorNameLabel = new JLabel("Doctor's name:");
        JLabel doctorSurnameLabel = new JLabel("Doctor's surname:");
        JLabel dateLabel = new JLabel("Date:");
        JLabel diagnosisLabel = new JLabel("Diagnosis:");
        JButton submitButton = new JButton("Create");
        JButton closeButton = new JButton("Close");
        patientNameField = new JTextField(20);
        patientSurnameField = new JTextField(20);
        patientCityField = new JTextField(20);
        patientStreetField = new JTextField(20);
        patientBuildingNumberField = new JTextField(20);
        patientBirthDateField = new DatePickerPartial().getDatePicker();
        doctorNameField = new JTextField(20);
        doctorSurnameField = new JTextField(20);
        dateField = new DatePickerPartial().getDatePicker();
        diagnosisField = new JTextField(20);

        contentPane.add(patientNameLabel);
        contentPane.add(patientNameField);
        contentPane.add(patientSurnameLabel);
        contentPane.add(patientSurnameField);
        contentPane.add(patientCityLabel);
        contentPane.add(patientCityField);
        contentPane.add(patientStreetLabel);
        contentPane.add(patientStreetField);
        contentPane.add(patientBuildingNumberLabel);
        contentPane.add(patientBuildingNumberField);
        contentPane.add(birthDateLabel);
        contentPane.add(patientBirthDateField);
        contentPane.add(doctorNameLabel);
        contentPane.add(doctorNameField);
        contentPane.add(doctorSurnameLabel);
        contentPane.add(doctorSurnameField);
        contentPane.add(dateLabel);
        contentPane.add(dateField);
        contentPane.add(diagnosisLabel);
        contentPane.add(diagnosisField);
        contentPane.add(closeButton);
        contentPane.add(submitButton);
        closeButton.addActionListener(getCloseButtonListener());
        submitButton.addActionListener(getSubmitButtonListener());

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
        return e -> { newWindow.dispose(); };
    }

    private ActionListener getSubmitButtonListener() {
        return e -> {
            DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("patientName", patientNameField.getText());
            params.put("patientSurname", patientSurnameField.getText());
            params.put("patientCity", patientCityField.getText());
            params.put("patientStreet", patientStreetField.getText());
            params.put("patientBuildingNumber", patientBuildingNumberField.getText());
            params.put("patientBirthDate", format.format(patientBirthDateField.getModel().getValue()));
            params.put("doctorName", doctorNameField.getText());
            params.put("doctorSurname", doctorSurnameField.getText());
            params.put("date", format.format(dateField.getModel().getValue()));
            params.put("diagnosis", diagnosisField.getText());
            controller.create(params);
        };
    }
}
