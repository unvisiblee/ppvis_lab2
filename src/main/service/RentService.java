package main.service;

import main.entity.RentRecord;
import main.entity.User;
import main.entity.Vehicle;
import main.repository.RentRepository;

import java.util.List;

public class RentService {


    private RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public User changeTenant(User user) {
        return rentRepository.changeTenant(user);
    }

    public List<RentRecord> getRentRecords() {
        return rentRepository.getRentRecords();
    }

    public RentRecord getRentRecordById(Integer id) {
        return rentRepository.getRentRecordById(id);
    }

    public Vehicle getVehicleById(Integer id) {
        return rentRepository.getVehicleById(id);
    }

    public List<Vehicle> getVehicles() {
        return rentRepository.getVehicles();
    }


}