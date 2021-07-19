package com.example.userservice.service;

import com.example.userservice.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public List<User> getAllUsers();
    public User getUserById(String id);
    public User updateUserById(String id, User user);
    public String deleteUser(String id);
    public String deleteAllUsers();
}
