package com.example.userservice.service;

import com.example.userservice.model.UserEntity;

import java.util.List;

public interface UserService {
    public UserEntity createUser(UserEntity userEntity);
    public List<UserEntity> getAllUsers();
    public UserEntity getUserById(String id);
    public UserEntity updateUserById(String id, UserEntity userEntity);
    public String deleteUser(String id);
    public String deleteAllUsers();
}
