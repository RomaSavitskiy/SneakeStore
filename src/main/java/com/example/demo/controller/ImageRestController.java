package com.example.demo.controller;

import com.example.demo.entity.Image;
import com.example.demo.service.ImagesService;
import com.example.demo.service.SneakersService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
@Slf4j
public class ImageRestController {
    private final SneakersService sneakersService;
    private final ImagesService imagesService;

    @GetMapping(value = "{id}")
    public void showImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Image image = imagesService.findFirstForSneaker(id);
        response.setContentType("image/jpeg,image/png,image/gif,image/jpg");
        response.getOutputStream().write(image.getImage());
        response.getOutputStream().close();
    }

    @GetMapping(value = "sneaker-img/{id}")
    public void showAllImageForSneakers(@PathVariable Long id, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg,image/png,image/gif,image/jpg");

        response.getOutputStream().write(imagesService.findById(id).getImage());
        response.getOutputStream().close();
    }
}
