package com.example.demo.controller;

import com.example.demo.DTO.AuthRequest;
/*import com.example.demo.jwt.JwtTokenUtil;*/
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Controller("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    /*private final JwtTokenUtil jwtTokenUtil;*/

    @PostMapping("/registration")
    public void createUser(@RequestBody AuthRequest authRequest) {
        userService.save(authRequest);
    }

    /*@PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        User user = userService.getTokenForUserIfExists(authRequest);
        return new AuthResponse(jwtTokenUtil.generateToken(user.getLogin()));
    }*/

    @PostMapping("/add")
    public String add() {

        return "index";
    }
}
