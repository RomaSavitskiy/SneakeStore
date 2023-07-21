package com.example.demo.controller;


import com.example.demo.service.SneakersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final SneakersService sneakersService;

    @GetMapping("/menu")
    public String adminPage(Model model) {
        model.addAttribute("sneakers", sneakersService.findAll());
        return "adminPage";
    }
}
