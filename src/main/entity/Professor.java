package main.entity;

public class Professor {
    private String name;
    private String lastName;
    private String patronymic;
    private String faculty;
    private String department;
    private String academicRank;
    private String degree;
    private int experience;

    public Professor(String name, String lastName, String patronymic, String faculty, String department, String academicRank, String degree, int experience) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.faculty = faculty;
        this.department = department;
        this.academicRank = academicRank;
        this.degree = degree;
        this.experience = experience;
    }

    public String getFullName() {
        return this.name + " " + this.lastName + " " + this.patronymic;
    }

    public Professor() {
        this("", "", "", "", "", "", "", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(String academicRank) {
        this.academicRank = academicRank;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
