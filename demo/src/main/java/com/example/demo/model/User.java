package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private  String lastName;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String mobNumber;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "account_creation_date", nullable = false)
    private String creation_date;
}
