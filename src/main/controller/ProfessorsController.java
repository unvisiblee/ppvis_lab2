package main.controller;

import main.filter.ProfessorsFilter;
import main.form.ProfessorSearchForm;
import main.form.ProfessorForm;
import main.mapper.ProfessorFormMapper;
import main.entity.Professor;
import main.entity.ProfessorSearchModel;
import main.repository.ProfessorRepository;

import java.io.File;
import java.util.List;

public class ProfessorsController {
    public ProfessorRepository professorRepository;

    public ProfessorsController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getAllProfessors() {
        return this.professorRepository.getProfessors();
    }

    public void create(Professor professor) {
        professorRepository.addProfessor(professor);
    }

    public void remove(List<Professor> forDeleting) {
        List<Professor> professors = this.professorRepository.getProfessors();
        professors.removeAll(forDeleting);
        this.professorRepository.setProfessors(professors);
    }

    public void open(File file) {
        professorRepository.setSourceFile(file);
        professorRepository.readAll();
    }

    public void save(File file) {
        professorRepository.setSourceFile(file);
        professorRepository.saveAll();
    }

    public List<Professor> applyFilters(ProfessorSearchForm form){
        ProfessorFormMapper getter = new ProfessorFormMapper();
        ProfessorSearchModel professor = getter.getProfessorSearchModel(form);

        ProfessorsFilter filter = new ProfessorsFilter();

        return filter.suitableProfessors(professor, this.getAllProfessors());
    }

    public void createFromForm(ProfessorForm form) {
        ProfessorFormMapper getter = new ProfessorFormMapper();
        Professor professor = getter.getProfessor(form);

        this.create(professor);
    }
}
