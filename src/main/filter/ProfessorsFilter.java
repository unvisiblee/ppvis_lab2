package main.filter;

import main.entity.Professor;
import main.entity.ProfessorSearchModel;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessorsFilter {
    private ProfessorSearchModel condition;

    public List<Professor> suitableProfessors(ProfessorSearchModel condition, List<Professor> records){
        this.condition = condition;

        return records.stream().filter(this::applyCondition).collect(Collectors.toList());

    }

    private boolean applyCondition(Professor professor) {
        if (!this.condition.getName().isEmpty() && !applyProfessorsNameFilter(professor))
            return false;
        if (!this.condition.getLastName().isEmpty() && !applyProfessorsLastNameFilter(professor))
            return false;
        if (!this.condition.getPatronymic().isEmpty() && !applyProfessorsPatronymicFilter(professor))
            return false;
        if (!this.condition.getFaculty().isEmpty() && !applyProfessorsFacultyFilter(professor))
            return false;
        if (!this.condition.getDepartment().isEmpty() && !applyProfessorsDepartmentFilter(professor))
            return false;
        if (!this.condition.getAcademicRank().isEmpty() && !applyProfessorsAcademicRankFilter(professor))
            return false;
        if (!this.condition.getDegree().isEmpty() && !applyProfessorsDegreeFilter(professor))
            return false;
        if (!applyProfessorExperienceBoundFilter(professor))
            return false;
        if (!this.condition.getDegree().isEmpty() && !applyProfessorsDegreeFilter(professor))
            return false;
        return (this.condition.getExperience() == 0) || applyProfessorsExperienceFilter(professor);
    }

    private boolean applyProfessorExperienceBoundFilter(Professor professor) {
        return (this.condition.getLowerBoundOfExperience() <= professor.getExperience() &&
                this.condition.getUpperBoundOfExperience() >= professor.getExperience());
    }

    private boolean applyProfessorsNameFilter(Professor professor) {
        return this.condition.getName().equals(professor.getName());
    }

    private boolean applyProfessorsLastNameFilter(Professor professor) {
        return this.condition.getLastName().equals(professor.getLastName());
    }

    private boolean applyProfessorsPatronymicFilter(Professor professor) {
        return this.condition.getPatronymic().equals(professor.getPatronymic());
    }

    private boolean applyProfessorsFacultyFilter(Professor professor) {
        return this.condition.getFaculty().equals(professor.getFaculty());
    }

    private boolean applyProfessorsDepartmentFilter(Professor professor) {
        return this.condition.getDepartment().equals(professor.getDepartment());
    }

    private boolean applyProfessorsAcademicRankFilter(Professor professor) {
        return this.condition.getAcademicRank().equals(professor.getAcademicRank());
    }

    private boolean applyProfessorsDegreeFilter(Professor professor) {
        return this.condition.getDegree().equals(professor.getDegree());
    }

    private boolean applyProfessorsExperienceFilter(Professor professor) {
        return this.condition.getExperience() == (professor.getExperience());
    }

}
