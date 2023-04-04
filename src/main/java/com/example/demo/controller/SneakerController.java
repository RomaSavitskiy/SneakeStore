package com.example.demo.controller;

import com.example.demo.entity.Sneakers;
import com.example.demo.service.ImagesService;
import com.example.demo.service.SneakersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping()
@RequiredArgsConstructor
@Controller
@Slf4j
public class SneakerController {
    private final SneakersService sneakersService;
    private final ImagesService imagesService;

    @GetMapping("/main")
    public String main() throws IOException {

        return "index";
    }

    @GetMapping("/addProducts")
    public String addProducts() {
        return "addProduct";
    }

    @PostMapping("/delete")
    public String deleteDiv(Model model) {
        return "index";
    }

    @GetMapping(value = "/products")
    public String showSneakers(Model model) {
        model.addAttribute("sneakers", sneakersService.findAll());
        List<Sneakers> sneakers = sneakersService.findAll();
        return "products";
    }

    @GetMapping("/men_sneakers")
    public String showMenSneakers(Model model) {
        model.addAttribute("sneakers", sneakersService.findAllByGender("men"));
        return "products";
    }

    @GetMapping("/women_sneakers")
    public String showWomenSneakers(Model model) {
        model.addAttribute("sneakers", sneakersService.findAllByGender("women"));
        return "products";
    }

    @GetMapping("/discount_sneakers")
    public String discountSneakers(Model model) {
        model.addAttribute("sneakers",sneakersService.findAllWithDiscount());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model) {
        Sneakers sneaker = sneakersService.findById(id);
        model.addAttribute("product", sneaker);
        model.addAttribute("productImages", imagesService.findAllImagesForSneaker(id));

        return "product";
    }
}
