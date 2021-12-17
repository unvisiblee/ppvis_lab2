package main.repository;

import main.entity.RentRecord;
import main.entity.User;
import main.entity.Vehicle;

import java.util.List;

public class TransientRentRepository implements  RentRepository {
    private List<RentRecord> rentRecords;
    private List<Vehicle> vehicles;

    public User changeTenant(User user) {
        return null;
    }

    public List<RentRecord> getRentRecords() {
        return null;
    }

    public RentRecord getRentRecordById(Integer id) {
        return null;
    }

    public Vehicle getVehicleById(Integer id) {
        return null;
    }

    public List<Vehicle> getVehicles() {
        return null;
    }

}