package main.form;

import main.entity.Professor;

import javax.swing.*;
import java.util.List;

/**
 * Form that has extra fields for upper and lower bound of experience
 * and faculty, department, rank, degree fields are editable combobox,
 * not text fields.
 */
public class ProfessorSearchForm extends AbstractProfessorForm {
    private final JComboBox<String> professorFacultyField;
    private final JComboBox<String> professorDepartmentField;
    private final JComboBox<String> professorAcademicRankField;
    private final JComboBox<String> professorDegreeField;
    private final JTextField lowerBoundField;
    private final JTextField upperBoundField;


    public ProfessorSearchForm() {
        super();
        JLabel professorFacultyLabel = new JLabel("Professor's faculty:");
        JLabel professorDepartmentLabel = new JLabel("Professor's department:");
        JLabel professorAcademicRankLabel = new JLabel("Professor's academic rank:");
        JLabel professorDegreeLabel = new JLabel("Professor's degree:");
        JLabel professorExperienceLowerBoundLabel = new JLabel("Experience Lower Bound:");
        JLabel professorExperienceUpperBoundLabel = new JLabel("Experience Upper Bound:");


        professorFacultyField = new JComboBox<>();

        professorDepartmentField = new JComboBox<>();

        professorAcademicRankField = new JComboBox<>();

        professorDegreeField = new JComboBox<>();

        lowerBoundField = new JTextField();
        upperBoundField = new JTextField();

        professorFacultyField.setEditable(true);
        professorDepartmentField.setEditable(true);
        professorAcademicRankField.setEditable(true);
        professorDegreeField.setEditable(true);

        panel.add(professorFacultyLabel);
        panel.add(professorFacultyField);
        panel.add(professorDepartmentLabel);
        panel.add(professorDepartmentField);
        panel.add(professorAcademicRankLabel);
        panel.add(professorAcademicRankField);
        panel.add(professorDegreeLabel);
        panel.add(professorDegreeField);
        panel.add(professorExperienceLowerBoundLabel);
        panel.add(lowerBoundField);
        panel.add(professorExperienceUpperBoundLabel);
        panel.add(upperBoundField);
    }

    public void updateData(List<Professor> professorList) {
        this.professorFacultyField.removeAllItems();
        professorList.stream().map(Professor::getFaculty).distinct().forEach(this.professorFacultyField::addItem);

        this.professorDepartmentField.removeAllItems();
        professorList.stream().map(Professor::getDepartment).distinct().forEach(this.professorDepartmentField::addItem);

        this.professorAcademicRankField.removeAllItems();
        professorList.stream().map(Professor::getAcademicRank).distinct().forEach(this.professorAcademicRankField::addItem);

        this.professorDegreeField.removeAllItems();
        professorList.stream().map(Professor::getDegree).distinct().forEach(this.professorDegreeField::addItem);


        this.professorDegreeField.setSelectedItem("");
        this.professorDepartmentField.setSelectedItem("");
        this.professorFacultyField.setSelectedItem("");
        this.professorAcademicRankField.setSelectedItem("");

        this.professorFacultyField.setEditable(true);
        this.professorDepartmentField.setEditable(true);
        this.professorAcademicRankField.setEditable(true);
        this.professorDegreeField.setEditable(true);
    }

    public String getProfessorFaculty() {
        return (String) professorFacultyField.getSelectedItem();
    }

    public String getProfessorDepartment() {
        return (String) professorDepartmentField.getSelectedItem();
    }

    public String getProfessorAcademicRank() {
        return (String) professorAcademicRankField.getSelectedItem();
    }

    public String getProfessorDegree() {
        return (String) professorDegreeField.getSelectedItem();
    }

    public String getExperienceLowerBound() {
        return this.lowerBoundField.getText();
    }

    public String getExperienceUpperBound() {
        return this.upperBoundField.getText();
    }
}
