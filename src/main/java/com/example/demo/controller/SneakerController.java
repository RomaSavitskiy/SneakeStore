package com.example.demo.controller;

import com.example.demo.entity.Images;
import com.example.demo.entity.Sneakers;
import com.example.demo.service.ImagesService;
import com.example.demo.service.SneakersService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @GetMapping("/adminMenu")
    public String adminPage(Model model) {
        model.addAttribute("sneakers", sneakersService.findAll());

        return "adminPage";
    }

    @GetMapping("/catalog")
    public String catalog(Model model, @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<Sneakers> items = sneakersService.getPage(pageable);

        model.addAttribute("sneakersPage", items);

        return "adminPage";
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

        Images newImage = new Images();
        newImage.setImage(image.getBytes());

        Sneakers sneakers = sneakersService.setSneakersBody(name, discount, count, price, image, gender);
        sneakersService.save(sneakers);

        newImage.setSneakers(sneakers);
        sneakers.getImages().add(newImage);

        imagesService.save(newImage);

        return "redirect:/adminMenu";
    }

    @GetMapping(value = "/products")
    public String showSneakers(Model model) {
        model.addAttribute("sneakers", sneakersService.findAll());
        /*model.addAttribute("sneakerImages", imagesService.findAll());*/
        List<Sneakers> sneakers = sneakersService.findAll();
        sneakers.get(0).getImages();
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

    @GetMapping("/kid_sneakers")
    public String kidSneakers(Model model) {
        model.addAttribute("sneakers",sneakersService.findAllByGender("kid"));
        return "products";
    }

    @GetMapping("/discount_sneakers")
    public String discountSneakers(Model model) {
        model.addAttribute("sneakers",sneakersService.findAllWithDiscount());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model) {
        model.addAttribute("product", sneakersService.findById(id));

        return "product";
    }
}
