package main.repository;

import main.XMLParsing.*;
import main.entity.Professor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private List<Professor> professors = new ArrayList<>();
    private File sourceFile;

    public ProfessorRepository() { }

    public void readAll() {
        professors = new ProfessorsXMLReader(sourceFile).readAll();
        if (professors == null) {
            professors = new ArrayList<>();
        }
    }

    public void saveAll() {
        new ProfessorsXMLWriter(sourceFile).writeAll(professors);
    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
    }

    public List<Professor> getProfessors() {
        return new ArrayList<>(professors);
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }
}
