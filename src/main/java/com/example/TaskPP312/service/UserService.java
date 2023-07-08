package com.example.TaskPP312.service;

import com.example.TaskPP312.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void removeUserById(int id);

    User getUserById(int id);

    List<User> getAllUsers();
}