package models;

public class Address {
    private String city;
    private String street;
    private String buildingNumber;

    public Address(String city, String street, String buildingNumber) {
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    public Address() {
        this("", "", "");
    }

    public String getFullAddress() {
        if (city.isEmpty()) {
            return street + " " + buildingNumber;
        }
        return city + ", " + street + " " + buildingNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
}
