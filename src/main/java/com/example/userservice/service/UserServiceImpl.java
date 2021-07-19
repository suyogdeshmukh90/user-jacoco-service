package com.example.userservice.service;

import com.example.userservice.Exception.UserNotFoundException;
import com.example.userservice.model.User;
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
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    @Override
    public User getUserById(String id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User updateUserById(String id, User user) {
        User user1=userRepo.findById(id).get();
        if(user1==null) {
            throw new UserNotFoundException("User with given id "+id+ " not found!");
        }
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setAge(user.getAge());
        user1.setAddress(user.getAddress());
        user1.setSalary(user.getSalary());
        userRepo.save(user1);
        return user1;
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
