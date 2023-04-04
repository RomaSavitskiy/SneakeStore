package com.example.demo.controller;

import com.example.demo.entity.Images;
import com.example.demo.entity.Sneakers;
import com.example.demo.service.ImagesService;
import com.example.demo.service.SneakersService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
@Slf4j
public class ImageRestController {
    private final SneakersService sneakersService;
    private final ImagesService imagesService;

    @GetMapping(value = "{id}")
    public void showImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Images images = imagesService.findFirstForSneaker(id);
        response.setContentType("image/jpeg,image/png,image/gif,image/jpg");
        response.getOutputStream().write(images.getImage());
        response.getOutputStream().close();
    }

    @GetMapping(value = "sneaker-img/{id}")
    public void showAllImageForSneakers(@PathVariable Long id, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg,image/png,image/gif,image/jpg");

        response.getOutputStream().write(imagesService.findById(id).getImage());
        response.getOutputStream().close();
    }
}
