package com.example.userservice.service;

import com.example.userservice.Exception.UserNotFoundException;
import com.example.userservice.model.UserEntity;
import com.example.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;
    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }


    @Override
    public UserEntity getUserById(String id) {
        return userRepo.findById(id).get();
    }

    @Override
    public UserEntity updateUserById(String id, UserEntity userEntity) {
        UserEntity userEntity1 =userRepo.findById(id).get();
        if(userEntity1 ==null) {
            throw new UserNotFoundException("User with given id "+id+ " not found!");
        }
        userEntity1.setFirstName(userEntity.getFirstName());
        userEntity1.setLastName(userEntity.getLastName());
        userEntity1.setAge(userEntity.getAge());
        userEntity1.setAddress(userEntity.getAddress());
        userEntity1.setSalary(userEntity.getSalary());
        userRepo.save(userEntity1);
        return userEntity1;
    }

    @Override
    public String deleteUser(String id) {
        userRepo.deleteById(id);
        return "Deleted Successfully!";
    }

    @Override
    public String deleteAllUsers() {
        userRepo.deleteAll();
        return "Deleted Successfully!";
    }
}
