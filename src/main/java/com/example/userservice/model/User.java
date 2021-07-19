package com.example.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;
    private Double salary;
}
