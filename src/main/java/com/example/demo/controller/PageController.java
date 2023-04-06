package com.example.demo.controller;

import com.example.demo.service.SneakersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class PageController {
    private final SneakersService sneakersService;

    @GetMapping("/order")
    public String order() {
        return "order";
    }

    @GetMapping("/main")
    public String main() throws IOException {

        return "index";
    }

    @GetMapping("/addProducts")
    public String addProducts() {
        return "addProduct";
    }

    @PostMapping("/delete")
    public String deleteDiv() {
        return "index";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/adminMenu")
    public String adminPage(Model model) {
        model.addAttribute("sneakers", sneakersService.findAll());

        return "adminPage";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
