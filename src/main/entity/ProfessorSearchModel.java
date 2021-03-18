package main.entity;

public class ProfessorSearchModel extends Professor{
    private int lowerBoundOfExperience;
    private int upperBoundOfExperience;

    public ProfessorSearchModel() {
        super();
    }

    public int getLowerBoundOfExperience() {
        return lowerBoundOfExperience;
    }

    public void setLowerBoundOfExperience(int lowerBoundOfExperience) {
        this.lowerBoundOfExperience = lowerBoundOfExperience;
    }

    public int getUpperBoundOfExperience() {
        return upperBoundOfExperience;
    }

    public void setUpperBoundOfExperience(int upperBoundOfExperience) {
        this.upperBoundOfExperience = upperBoundOfExperience;
    }
}
