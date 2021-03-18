package main.form;

import javax.swing.*;

public class ProfessorForm extends AbstractProfessorForm {

    private final JTextField professorFacultyField;
    private final JTextField professorDepartmentField;
    private final JTextField professorAcademicRankField;
    private final JTextField professorDegreeField;



    public ProfessorForm() {
        super();
        JLabel professorFacultyLabel = new JLabel("Professor's faculty:");
        JLabel professorDepartmentLabel = new JLabel("Professor's department:");
        JLabel professorAcademicRankLabel = new JLabel("Professor's academic rank:");
        JLabel professorDegreeLabel = new JLabel("Professor's degree:");

        professorFacultyField = new JTextField(20);
        professorDepartmentField = new JTextField(20);
        professorAcademicRankField = new JTextField(20);
        professorDegreeField = new JTextField(20);

        panel.add(professorFacultyLabel);
        panel.add(professorFacultyField);
        panel.add(professorDepartmentLabel);
        panel.add(professorDepartmentField);
        panel.add(professorAcademicRankLabel);
        panel.add(professorAcademicRankField);
        panel.add(professorDegreeLabel);
        panel.add(professorDegreeField);
    }



    public JPanel getPanel() {
        return panel;
    }

    public String getProfessorFaculty() {
        return professorFacultyField.getText();
    }

    public String getProfessorDepartment() {
        return professorDepartmentField.getText();
    }

    public String getProfessorAcademicRank() {
        return professorAcademicRankField.getText();
    }

    public String getProfessorDegree() {
        return professorDegreeField.getText();
    }


}

