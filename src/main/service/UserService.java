package main.service;

import main.entity.User;
import main.repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    public boolean addUser(User user) {
        return userRepository.addUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public boolean changeUserRole(String role) {
        return userRepository.changeUserRole(role);
    }

    public List<User> getTopUsers() {
        return userRepository.getTopUsers();
    }

    public void unblockUser(User user) {

    }

}