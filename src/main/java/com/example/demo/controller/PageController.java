package com.example.demo.controller;

import com.example.demo.service.SneakersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PageController {
    private final SneakersService sneakersService;

    @GetMapping("/adminMenu")
    public String adminPage(Model model) {
        model.addAttribute("sneakers", sneakersService.findAll());
        return "adminPage";
    }
}
