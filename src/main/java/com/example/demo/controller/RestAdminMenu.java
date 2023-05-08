package com.example.demo.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest")
@SecurityRequirement(name = "JWT")
public class RestAdminMenu {
    @GetMapping
    public List<String> getTestData1() {
        return Arrays.asList("Hello", "world", "123");
    }
}
