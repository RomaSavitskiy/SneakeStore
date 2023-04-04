package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unique = true указывает, что значение должно быть уникальным
    @Column(unique = true)
    private String login;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
