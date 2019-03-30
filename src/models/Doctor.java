package models;

public class Doctor {
    private String name;
    private String surname;

    public Doctor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Doctor() {
        this("", "");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
