package views;

import controllers.StudentsController;

import javax.swing.*;
import java.awt.*;

public class StudentFormPartial {
    private StudentsController controller;
    private JPanel panel;
    private JTextField studentNameField;
    private JTextField studentSurnameField;
    private JTextField studentLastNameField;
    private JTextField studentSistersCountField;
    private JTextField studentBrothersCountField;
    private JTextField motherNameField;
    private JTextField motherSurnameField;
    private JTextField motherLastNameField;
    private JTextField motherEarningsField;
    private JTextField fatherNameField;
    private JTextField fatherSurnameField;
    private JTextField fatherLastNameField;
    private JTextField fatherEarningsField;

    public StudentFormPartial(StudentsController controller) {
        this.controller = controller;
        panel = new JPanel(new GridLayout(17, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel studentNameLabel = new JLabel("Student's name:");
        JLabel studentSurnameLabel = new JLabel("Student's surname:");
        JLabel studentLastNameLabel = new JLabel("Student's last name:");
        JLabel studentSistersCountLabel = new JLabel("Student's sisters count:");
        JLabel studentBrothersCountLabel = new JLabel("Student's brothers count:");
        JLabel motherNameLabel = new JLabel("Mother's name:");
        JLabel motherSurnameLabel = new JLabel("Mother's surname:");
        JLabel motherLastNameLabel = new JLabel("Mother's last name:");
        JLabel motherEarningsLabel = new JLabel("Mother's earnings:");
        JLabel fatherNameLabel = new JLabel("Father's name:");
        JLabel fatherSurnameLabel = new JLabel("Father's surname:");
        JLabel fatherLastNameLabel = new JLabel("Father's last name:");
        JLabel fatherEarningsLabel = new JLabel("Father's earnings:");
        studentNameField = new JTextField(20);
        studentSurnameField = new JTextField(20);
        studentLastNameField = new JTextField(20);
        studentSistersCountField = new JTextField(20);
        studentBrothersCountField = new JTextField(20);
        motherNameField = new JTextField(20);
        motherSurnameField = new JTextField(20);
        motherLastNameField = new JTextField(20);
        motherEarningsField = new JTextField(20);
        fatherNameField = new JTextField(20);
        fatherSurnameField = new JTextField(20);
        fatherLastNameField = new JTextField(20);
        fatherEarningsField = new JTextField(20);

        panel.add(studentNameLabel);
        panel.add(studentNameField);
        panel.add(studentSurnameLabel);
        panel.add(studentSurnameField);
        panel.add(studentLastNameLabel);
        panel.add(studentLastNameField);
        panel.add(studentSistersCountLabel);
        panel.add(studentSistersCountField);
        panel.add(studentBrothersCountLabel);
        panel.add(studentBrothersCountField);
        panel.add(motherNameLabel);
        panel.add(motherNameField);
        panel.add(motherSurnameLabel);
        panel.add(motherSurnameField);
        panel.add(motherLastNameLabel);
        panel.add(motherLastNameField);
        panel.add(motherEarningsLabel);
        panel.add(motherEarningsField);
        panel.add(fatherNameLabel);
        panel.add(fatherNameField);
        panel.add(fatherSurnameLabel);
        panel.add(fatherSurnameField);
        panel.add(fatherLastNameLabel);
        panel.add(fatherLastNameField);
        panel.add(fatherEarningsLabel);
        panel.add(fatherEarningsField);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getStudentName() {
        return studentNameField.getText();
    }

    public String getStudentSurname() {
        return studentSurnameField.getText();
    }

    public String getStudentLastName() {
        return studentLastNameField.getText();
    }

    public String getStudentSistersCount() {
        return studentSistersCountField.getText();
    }

    public String getStudentBrothersCount() {
        return studentBrothersCountField.getText();
    }

    public String getMotherName() {
        return motherNameField.getText();
    }

    public String getMotherSurname() {
        return motherSurnameField.getText();
    }

    public String getMotherLastName() {
        return motherLastNameField.getText();
    }

    public String getMotherEarnings() {
        return motherEarningsField.getText();
    }

    public String getFatherName() {
        return fatherNameField.getText();
    }

    public String getFatherSurname() {
        return fatherSurnameField.getText();
    }

    public String getFatherLastName() {
        return fatherLastNameField.getText();
    }

    public String getFatherEarnings() {
        return fatherEarningsField.getText();
    }
}

