package com.example.demo.controller;

import com.example.demo.DTO.AuthRequest;
import com.example.demo.DTO.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.jwt.JwtTokenUtil;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    /*@PostMapping  ("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest,
                              HttpServletResponse response, HttpServletRequest request) {
        User user = userService.getTokenForUserIfExists(authRequest);
        String token = jwtTokenUtil.generateToken(user.getLogin());

        HttpSession session = request.getSession();
        session.setAttribute("jwtToken", token);

        return new AuthResponse(token);
    }*/

    @PostMapping("/add")
    public String add() {

        return "index";
    }
}
