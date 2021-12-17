package main.repository;

import main.entity.RentRecord;
import main.entity.User;
import main.entity.Vehicle;

import java.util.List;

public interface RentRepository {
    User changeTenant(User user);
    List<RentRecord> getRentRecords();
    RentRecord getRentRecordById(Integer id);
    Vehicle getVehicleById(Integer id);
    List<Vehicle> getVehicles();
}
