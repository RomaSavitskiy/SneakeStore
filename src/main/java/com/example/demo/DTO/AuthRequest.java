package com.example.demo.DTO;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
