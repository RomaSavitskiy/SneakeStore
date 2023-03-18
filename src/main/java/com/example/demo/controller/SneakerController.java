package com.example.demo.controller;

import com.example.demo.entity.Image;
import com.example.demo.entity.Sneakers;
import com.example.demo.service.SneakersService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RequestMapping()
@RequiredArgsConstructor
@Controller
@Slf4j
public class SneakerController {
    private final SneakersService sneakersService;
    @GetMapping("/main")
    public String main() throws IOException {

        return "index";
    }

    @GetMapping("/addProducts")
    public String addProducts() {
        return "addProduct";
    }

    @GetMapping(value = "/products")
    public String products(Model model) {
        model.addAttribute("sneakers", sneakersService.findAll());
        return "products";
    }

    @PostMapping("showImage")
    public void showImage(@PathVariable Sneakers sneakers, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg,image/png,image/gif,image/jpg");
        response.getOutputStream().write(sneakers.getImage());
        response.getOutputStream().close();
    }


    @PostMapping("/delete")
    public String deleteDiv(Model model) {
        return "index";
    }

    @PostMapping("/saveProduct")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("discount") Long discount,
                             @RequestParam("count") Long count,
                             @RequestParam("price") Long price,
                             @RequestParam("image") MultipartFile image) throws IOException {
        log.info("before");
        Sneakers sneakers = new Sneakers();

        sneakers.setName(name);
        sneakers.setPrice(price);
        sneakers.setImage(image.getBytes());
        sneakers.setCount(count);
        sneakers.setDiscount(discount);

        sneakersService.save(sneakers);
        log.info("After");

        return "addProduct";
    }
}
