package com.example.demo.controller;

import com.example.demo.service.SneakersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class PageController {
    private final SneakersService sneakersService;

   /* @GetMapping("/login")
    public String getLogin() {
        return "login";
    }*/
}
