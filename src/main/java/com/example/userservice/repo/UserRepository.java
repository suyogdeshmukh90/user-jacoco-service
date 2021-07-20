package com.example.userservice.repo;

import com.example.userservice.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<UserEntity,String> {
}
