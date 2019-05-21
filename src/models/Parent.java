package models;

public class Parent {
    private String name;
    private String surname;
    private String lastName;
    private Double earnings;

    public Parent(String name, String surname, String lastName, double earnings) {
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.earnings = earnings;
    }

    public Parent() {
        this("", "", "", 0);
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

    public Double getEarnings() {
        return earnings;
    }

    public String getFullName() {
        return name + " " + surname + " " + lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEarnings(Double earnings) {
        this.earnings = earnings;
    }
}
