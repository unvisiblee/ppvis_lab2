package main.controller;

import main.entity.User;
import main.service.UserService;

import java.util.List;

public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
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