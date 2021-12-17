package main.repository;

import main.entity.User;

import java.util.List;

public interface UserRepository {
    User getUserById(Integer id);
    boolean addUser(User user);
    List<User> getAllUsers();
    boolean changeUserRole(String role);
    List<User> getTopUsers();
}
