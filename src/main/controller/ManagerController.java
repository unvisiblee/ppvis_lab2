package main.controller;

import main.entity.RentRecord;
import main.entity.User;
import main.entity.Vehicle;
import main.service.RentService;
import main.service.UserService;

import java.util.List;

public class ManagerController {

    private UserService userService;
    private RentService rentService;


    public ManagerController(UserService userService, RentService rentService) {
        this.userService = userService;
        this.rentService = rentService;
    }

    public User changeTenant(User user) {
        return rentService.changeTenant(user);
    }

    public List<RentRecord> getRentRecords() {
        return rentService.getRentRecords();
    }

    public RentRecord getRentRecordById(Integer id) {
        return rentService.getRentRecordById(id);
    }

    public Vehicle getVehicleById(Integer id) {
        return rentService.getVehicleById(id);
    }

    public List<Vehicle> getVehicles() {
        return rentService.getVehicles();
    }


    public User getUserById(Integer id) {
        return userService.getUserById(id);
    }

    public boolean addUser(User user) {
        return userService.addUser(user);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public boolean changeUserRole(String role) {
        return userService.changeUserRole(role);
    }

    public List<User> getTopUsers() {
        return userService.getTopUsers();
    }

    public void unblockUser(User user) {
        userService.unblockUser(user);
    }

}