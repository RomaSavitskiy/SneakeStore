package com.example.demo.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageDto {
    private String name;
    private String description;
    private double price;
    private MultipartFile image;
}
