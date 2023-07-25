package com.example.demo.controller;

import com.example.demo.DTO.AuthRequest;
import com.example.demo.jwt.JwtTokenUtil;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping ("/save")
    public String createUser(@RequestParam String username, @RequestParam String password) {
        AuthRequest authRequest = new AuthRequest(username, password);
        userService.save(authRequest);
        return "index";
    }
}
