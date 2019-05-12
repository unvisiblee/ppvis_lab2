package selections;

import models.Student;

import java.util.ArrayList;

public class StudentsSelection {
    private ArrayList<Student> result = new ArrayList<>();
    private Student condition = new Student();


    public ArrayList<Student> suitableStudents(Student condition, ArrayList<Student> records){
        this.condition = condition;
        records.forEach(e -> applyCondition(e));

        return this.result;
    }

    private void applyCondition(Student student) {
        if (!this.condition.getName().isEmpty()) applyStudentNameFilter(student);
        if (!this.condition.getSurname().isEmpty()) applyStudentSurNameFilter(student);
        if (!this.condition.getLastName().isEmpty()) applyStudentLastNameFilter(student);
        if (!(this.condition.getSistersCount() == 0)) applyStudentSistersCountFilter(student);
        if (!(this.condition.getBrothersCount() == 0)) applyStudentBrothersCountFilter(student);
        if (!(this.condition.getMotherEarnings() == 0)) applyStudentMotherEarningsFilter(student);
        if (!this.condition.getMotherName().isEmpty()) applyStudentMotherNameFilter(student);
        if (!this.condition.getMotherSurname().isEmpty()) applyStudentMotherSurnameFilter(student);
        if (!this.condition.getMotherLastName().isEmpty()) applyStudentMotherLastNameFilter(student);
        if (!(this.condition.getFatherEarnings() == 0)) applyStudentFatherEarningsFilter(student);
        if (!this.condition.getFatherName().isEmpty()) applyStudentFatherNameFilter(student);
        if (!this.condition.getFatherSurname().isEmpty()) applyStudentFatherSurnameFilter(student);
        if (!this.condition.getFatherLastName().isEmpty()) applyStudentFatherLastNameFilter(student);
    }

    private void applyStudentNameFilter(Student student) {
        if (this.condition.getName().equals(student.getName())) this.result.add(student);
    }

    private void applyStudentSurNameFilter(Student student) {
        if (this.condition.getSurname().equals(student.getSurname())) this.result.add(student);
    }

    private void applyStudentLastNameFilter(Student student) {
        if (this.condition.getLastName().equals(student.getLastName())) this.result.add(student);
    }

    private void applyStudentSistersCountFilter(Student student) {
        if (this.condition.getSistersCount().equals(student.getSistersCount())) this.result.add(student);
    }

    private void applyStudentBrothersCountFilter(Student student) {
        if (this.condition.getBrothersCount().equals(student.getBrothersCount())) this.result.add(student);
    }

    private void applyStudentMotherEarningsFilter(Student student) {
        if (this.condition.getMotherEarnings().equals(student.getMotherEarnings())) this.result.add(student);
    }

    private void applyStudentMotherNameFilter(Student student) {
        if (this.condition.getMotherName().equals(student.getMotherName())) this.result.add(student);
    }

    private void applyStudentMotherSurnameFilter(Student student) {
        if (this.condition.getMotherSurname().equals(student.getMotherSurname())) this.result.add(student);
    }

    private void applyStudentMotherLastNameFilter(Student student) {
        if (this.condition.getMotherLastName().equals(student.getMotherLastName())) this.result.add(student);
    }
    private void applyStudentFatherEarningsFilter(Student student) {
        if (this.condition.getFatherEarnings().equals(student.getFatherEarnings())) this.result.add(student);
    }

    private void applyStudentFatherNameFilter(Student student) {
        if (this.condition.getFatherName().equals(student.getFatherName())) this.result.add(student);
    }

    private void applyStudentFatherSurnameFilter(Student student) {
        if (this.condition.getFatherSurname().equals(student.getFatherSurname())) this.result.add(student);
    }

    private void applyStudentFatherLastNameFilter(Student student) {
        if (this.condition.getFatherLastName().equals(student.getFatherLastName())) this.result.add(student);
    }
}
