package main.service;

import main.entity.User;
import main.repository.UserRepository;

public class AuthService {
    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signup(User user) {
        return null;
    }

    public User logIn(String phoneNumber, String password) {
        return null;
    }
}