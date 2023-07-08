package com.example.TaskPP312.service;

import com.example.TaskPP312.model.User;
import com.example.TaskPP312.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}