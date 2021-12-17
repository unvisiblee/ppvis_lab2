package main.repository;

import main.entity.User;

import java.util.List;

public class TransientUserRepository implements UserRepository {
    List<User> users;

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean changeUserRole(String role) {
        return false;
    }

    @Override
    public List<User> getTopUsers() {
        return null;
    }
}