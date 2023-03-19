package com.example.demo.controller;

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
                             @RequestParam("image") MultipartFile image,
                             @RequestParam("gender") String gender) throws IOException {

        Sneakers sneakers = sneakersService.setSneakersBody(name, discount, count, price, image, gender);
        sneakersService.save(sneakers);

        return "addProduct";
    }

    @GetMapping("/men_sneakers")
    public String menSneakers(Model model) {
        model.addAttribute("menSneakers", sneakersService.findAllByGender("men"));
        return "men_sneakers";
    }

    @GetMapping("/women_sneakers")
    public String womenSneakers(Model model) {
        model.addAttribute("womenSneakers", sneakersService.findAllByGender("women"));
        return "women_sneakers";
    }

    @GetMapping("/kid_sneakers")
    public String kidSneakers(Model model) {
        model.addAttribute("kidSneakers",sneakersService.findAllByGender("kid"));
        return "kid_sneakers";
    }
}
