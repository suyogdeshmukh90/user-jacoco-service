package com.example.userservice.controller;

import com.example.userservice.model.User;
import com.example.userservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getAllUsers(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") String id,@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserById(id,user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteAllUsers());
    }
}
