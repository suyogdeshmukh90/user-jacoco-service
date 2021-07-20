package com.example.userservice.controller;

import com.example.userservice.model.UserEntity;
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
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userEntity));
    }
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getAllUsers(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUserById(@PathVariable("id") String id, @RequestBody UserEntity userEntity) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserById(id, userEntity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteAllUsers());
    }
}
