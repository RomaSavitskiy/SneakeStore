package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/saveUser")
    public String addUser(@RequestParam(name = "login") String login,
                          @RequestParam(name = "password") String password) {

        Role role = new Role();
        role.setName("USER");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);

        userService.save(user);

        return "index";
    }
}
