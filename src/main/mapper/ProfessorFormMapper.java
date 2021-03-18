package main.mapper;


import main.form.AbstractProfessorForm;
import main.form.ProfessorSearchForm;
import main.entity.Professor;
import main.entity.ProfessorSearchModel;

public class ProfessorFormMapper {
    public Professor getProfessor(AbstractProfessorForm form) {

        Professor professor = new Professor();

        setMainFields(form, professor);

        return professor;
    }

    public ProfessorSearchModel getProfessorSearchModel(ProfessorSearchForm form) {
        ProfessorSearchModel professor = new ProfessorSearchModel();

        setMainFields(form, professor);
        professor.setLowerBoundOfExperience(
                form.getExperienceLowerBound().isEmpty() ? Integer.MIN_VALUE : Integer.parseInt(form.getExperienceLowerBound()));
        professor.setUpperBoundOfExperience(
                form.getExperienceUpperBound().isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(form.getExperienceUpperBound()));

        return professor;
    }

    private void setMainFields(AbstractProfessorForm form, Professor professor) {
        professor.setName(form.getProfessorName());
        professor.setLastName(form.getProfessorLastName());
        professor.setPatronymic(form.getProfessorPatronymic());
        professor.setFaculty(form.getProfessorFaculty());
        professor.setDepartment(form.getProfessorDepartment());
        professor.setAcademicRank(form.getProfessorAcademicRank());
        professor.setDegree(form.getProfessorDegree());
        professor.setExperience(form.getProfessorExperience().isEmpty() ? 0 : Integer.parseInt(form.getProfessorExperience()));
    }
}
