package main.form;


import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public abstract class AbstractProfessorForm {
    protected final JPanel panel;
    private final JTextField professorNameField;
    private final JTextField professorLastNameField;
    private final JTextField professorPatronymicField;

    private final JTextField professorExperienceField;



    public AbstractProfessorForm() {
        panel = new JPanel(new GridLayout(17, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel professorNameLabel = new JLabel("Professor's name:");
        JLabel professorLastNameLabel = new JLabel("Professor's last name:");
        JLabel professorPatronymicLabel = new JLabel("Professor's patronymic:");
        JLabel professorExperienceLabel = new JLabel("Professor's experience:");


        professorNameField = new JTextField(20);
        professorLastNameField = new JTextField(20);
        professorPatronymicField = new JTextField(20);
        professorExperienceField = new JTextField(20);



        panel.add(professorNameLabel);
        panel.add(professorNameField);
        panel.add(professorLastNameLabel);
        panel.add(professorLastNameField);
        panel.add(professorPatronymicLabel);
        panel.add(professorPatronymicField);

        panel.add(professorExperienceLabel);
        panel.add(professorExperienceField);
    }



    public JPanel getPanel() {
        return panel;
    }

    public String getProfessorName() {
        return professorNameField.getText();
    }

    public String getProfessorLastName() {
        return professorLastNameField.getText();
    }

    public String getProfessorPatronymic() {
        return professorPatronymicField.getText();
    }

    public String getProfessorExperience() {
        return professorExperienceField.getText();
    }

    public abstract String getProfessorFaculty();

    public abstract String getProfessorDepartment();

    public abstract String getProfessorAcademicRank();

    public abstract String getProfessorDegree();
}
