package models;

import java.util.HashMap;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class Student {
    private String name;
    private String surname;
    private String lastName;
    private Integer sistersCount;
    private Integer brothersCount;
    private Parent mother;
    private Parent father;

    public Student(String name, String surname, String lastName, Integer sistersCount, Integer brothersCount, Parent mother, Parent father) {
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.sistersCount = sistersCount;
        this.brothersCount = brothersCount;
        this.mother = mother;
        this.father = father;
    }

    public Student() {
        this("", "", "", 0, 0, new Parent(), new Parent());
    }

    public Student(HashMap<String, String> attributes) {
        this.mother = new Parent(attributes.get("motherName"), attributes.get("motherSurname"), attributes.get("motherLastName"), parseDouble(attributes.get("motherEarnings")));
        this.father = new Parent(attributes.get("fatherName"), attributes.get("fatherSurname"), attributes.get("fatherLastName"), parseDouble(attributes.get("fatherEarnings")));

        this.name = attributes.get("studentName");
        this.surname = attributes.get("studentSurname");
        this.lastName = attributes.get("studentLastName");
        this.sistersCount = parseInt(attributes.get("studentSistersCount"));
        this.brothersCount = parseInt(attributes.get("studentBrothersCount"));
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return name + " " + surname + " " + lastName;
    }

    public Integer getSistersCount() {
        return sistersCount;
    }

    public Integer getBrothersCount() {
        return brothersCount;
    }

    public Parent getMother() {
        return mother;
    }

    public Parent getFather() {
        return father;
    }

    public Double getMotherEarnings() {
        return mother.getEarnings();
    }

    public String getMotherFullName() {
        return mother.getFullName();
    }

    public String getMotherName() {
        return mother.getName();
    }

    public String getMotherSurname() {
        return mother.getSurname();
    }

    public String getMotherLastName() {
        return mother.getLastName();
    }

    public Double getFatherEarnings() {
        return father.getEarnings();
    }

    public String getFatherFullName() {
        return father.getFullName();
    }

    public String getFatherName() {
        return father.getName();
    }

    public String getFatherSurname() {
        return father.getSurname();
    }

    public String getFatherLastName() {
        return father.getLastName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public void setSistersCount(Integer sistersCount) {
        this.sistersCount = sistersCount;
    }

    public void setBrothersCount(Integer brothersCount) {
        this.brothersCount = brothersCount;
    }

    public void setMother(Parent mother) {
        this.mother = mother;
    }

    public void setMotherName(String motherName) {
        this.mother.setName(motherName);
    }

    public void setMotherSurname(String motherSurname) {
        this.mother.setSurname(motherSurname);
    }

    public void setMotherLastName(String motherLastName) {
        this.mother.setLastName(motherLastName);
    }

    public void setMotherEarnings(Double motherEarnings) {
        this.mother.setEarnings(motherEarnings);
    }

    public void setFatherName(String fatherName) {
        this.father.setName(fatherName);
    }

    public void setFatherSurname(String fatherSurname) {
        this.father.setSurname(fatherSurname);
    }

    public void setFatherLastName(String fatherLastName) {
        this.father.setLastName(fatherLastName);
    }

    public void setFatherEarnings(Double fatherEarnings) {
        this.father.setEarnings(fatherEarnings);
    }

    public void setFather(Parent father) {
        this.father = father;
    }
}
