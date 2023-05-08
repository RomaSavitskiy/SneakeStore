package com.example.demo.controller;

import com.example.demo.DTO.AuthRequest;
/*import com.example.demo.jwt.JwtTokenUtil;*/
import com.example.demo.DTO.AuthResponse;
import com.example.demo.DTO.UserDto;
import com.example.demo.entity.User;
import com.example.demo.jwt.JwtTokenUtil;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping ("/save")
    public void createUser(@RequestBody AuthRequest authRequest) {
        userService.save(authRequest);
    }

    @PostMapping  ("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        User user = userService.getTokenForUserIfExists(authRequest);
        log.info("Hello world");
        return new AuthResponse(jwtTokenUtil.generateToken(user.getLogin()));
    }

    @PostMapping("/add")
    public String add() {

        return "index";
    }
}
