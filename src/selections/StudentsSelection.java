package selections;

import models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsSelection {
    private List<Student> result = new ArrayList<>();
    private Student condition = new Student();

    public List<Student> suitableStudents(Student condition, List<Student> records){
        this.condition = condition;

        for(Student s: records){
            applyCondition(s);
        }

        return this.result;
    }

    private void applyCondition(Student student) {
        if (!this.condition.getName().isEmpty() && applyStudentNameFilter(student)) this.result.add(student);
        if (!this.condition.getSurname().isEmpty() && applyStudentSurNameFilter(student)) this.result.add(student);
        if (!this.condition.getLastName().isEmpty() && applyStudentLastNameFilter(student)) this.result.add(student);
        if (!(this.condition.getSistersCount() == 0) && applyStudentSistersCountFilter(student)) this.result.add(student);
        if (!(this.condition.getBrothersCount() == 0) && applyStudentBrothersCountFilter(student)) this.result.add(student);
        if (!(this.condition.getMotherEarnings() == 0) && applyStudentMotherEarningsFilter(student)) this.result.add(student);
        if (!this.condition.getMotherName().isEmpty() && applyStudentMotherNameFilter(student)) this.result.add(student);
        if (!this.condition.getMotherSurname().isEmpty() && applyStudentMotherSurnameFilter(student)) this.result.add(student);
        if (!this.condition.getMotherLastName().isEmpty() && applyStudentMotherLastNameFilter(student)) this.result.add(student);
        if (!(this.condition.getFatherEarnings() == 0) && applyStudentFatherEarningsFilter(student)) this.result.add(student);
        if (!this.condition.getFatherName().isEmpty() && applyStudentFatherNameFilter(student)) this.result.add(student);
        if (!this.condition.getFatherSurname().isEmpty() && applyStudentFatherSurnameFilter(student)) this.result.add(student);
        if (!this.condition.getFatherLastName().isEmpty() && applyStudentFatherLastNameFilter(student)) this.result.add(student);
    }

    private boolean applyStudentNameFilter(Student student) {
        return this.condition.getName().equals(student.getName());
    }

    private boolean applyStudentSurNameFilter(Student student) {
        return this.condition.getSurname().equals(student.getSurname());
    }

    private boolean applyStudentLastNameFilter(Student student) {
        return this.condition.getLastName().equals(student.getLastName());
    }

    private boolean applyStudentSistersCountFilter(Student student) {
        return this.condition.getSistersCount().equals(student.getSistersCount());
    }

    private boolean applyStudentBrothersCountFilter(Student student) {
        return this.condition.getBrothersCount().equals(student.getBrothersCount());
    }

    private boolean applyStudentMotherEarningsFilter(Student student) {
        return this.condition.getMotherEarnings().equals(student.getMotherEarnings());
    }

    private boolean applyStudentMotherNameFilter(Student student) {
        return this.condition.getMotherName().equals(student.getMotherName());
    }

    private boolean applyStudentMotherSurnameFilter(Student student) {
        return this.condition.getMotherSurname().equals(student.getMotherSurname());
    }

    private boolean applyStudentMotherLastNameFilter(Student student) {
        return this.condition.getMotherLastName().equals(student.getMotherLastName());
    }
    private boolean applyStudentFatherEarningsFilter(Student student) {
        return this.condition.getFatherEarnings().equals(student.getFatherEarnings());
    }

    private boolean applyStudentFatherNameFilter(Student student) {
        return this.condition.getFatherName().equals(student.getFatherName());
    }

    private boolean applyStudentFatherSurnameFilter(Student student) {
        return this.condition.getFatherSurname().equals(student.getFatherSurname());
    }

    private boolean applyStudentFatherLastNameFilter(Student student) {
        return this.condition.getFatherLastName().equals(student.getFatherLastName());
    }
}
