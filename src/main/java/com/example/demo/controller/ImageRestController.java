package com.example.demo.controller;

import com.example.demo.entity.Sneakers;
import com.example.demo.service.SneakersService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageRestController {
    private final SneakersService sneakersService;

    @GetMapping(value = "{id}")
    public void showImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Sneakers sneakers = sneakersService.findById(id);
        response.setContentType("image/jpeg,image/png,image/gif,image/jpg");
        response.getOutputStream().write(sneakers.getImage());
        response.getOutputStream().close();
    }
}
