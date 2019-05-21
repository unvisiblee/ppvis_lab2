package dataGetters;

import models.Parent;
import models.Student;
import views.StudentFormPartial;

public class StudentFormGetter {
    public Student getData(StudentFormPartial form) {
        Student student = new Student();
        student.setName(form.getStudentName());
        student.setLastName(form.getStudentLastName());
        student.setSurname(form.getStudentSurname());

        student.setSistersCount(form.getStudentSistersCount().isEmpty() ? 0 : Integer.valueOf(form.getStudentSistersCount()));
        student.setBrothersCount(form.getStudentBrothersCount().isEmpty() ? 0 : Integer.valueOf(form.getStudentBrothersCount()));

        Parent mother = new Parent();
        mother.setName(form.getMotherName());
        mother.setLastName(form.getMotherLastName());
        mother.setSurname(form.getMotherSurname());
        mother.setEarnings(form.getMotherEarnings().isEmpty() ? 0.0 : Double.valueOf(form.getMotherEarnings()));

        student.setMother(mother);

        Parent father = new Parent();
        father.setName(form.getFatherName());
        father.setLastName(form.getFatherLastName());
        father.setSurname(form.getFatherSurname());
        father.setEarnings(form.getFatherEarnings().isEmpty() ? 0.0 : Double.valueOf(form.getFatherEarnings()));

        student.setFather(father);
        return student;
    }
}
