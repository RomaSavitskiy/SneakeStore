package com.example.demo.controller;

import com.example.demo.entity.KidSneakers;
import com.example.demo.entity.MenSneakers;
import com.example.demo.entity.Sneakers;
import com.example.demo.entity.WomenSneakers;
import com.example.demo.service.KidSneakersService;
import com.example.demo.service.MenSneakersService;
import com.example.demo.service.SneakersService;
import com.example.demo.service.WomenSneakersService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@RequestMapping()
@RequiredArgsConstructor
@Controller
@Slf4j
public class SneakerController {
    private final SneakersService sneakersService;
    private final MenSneakersService menSneakersService;
    private final WomenSneakersService womenSneakersService;
    private final KidSneakersService kidSneakersService;
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
        log.info("before");

        Sneakers sneakers = sneakersService.setSneakersBody(name, discount, count, price, image, gender);
        sneakersService.save(sneakers);

        if(Objects.equals(gender, "men")) {
            MenSneakers menSneakers = new MenSneakers();
            menSneakersService.setMenSneakersBody(menSneakers, sneakers);
            menSneakersService.save(menSneakers);
        }

        if(Objects.equals(gender, "women")) {
            WomenSneakers womenSneakers = new WomenSneakers();
            womenSneakersService.setWomenSneakersBody(womenSneakers, sneakers);
            womenSneakersService.save(womenSneakers);
        }

        if(Objects.equals(gender, "kid")) {
            KidSneakers kidSneakers = new KidSneakers();
            kidSneakersService.setKidSneakersBody(kidSneakers, sneakers);
            kidSneakersService.save(kidSneakers);
        }

        log.info("After");

        return "addProduct";
    }

    @GetMapping("/men_sneakers")
    public String menSneakers(Model model) {
        model.addAttribute("menSneakers", menSneakersService.findAll());
        return "men_sneakers";
    }

    @GetMapping("/women_sneakers")
    public String womenSneakers(Model model) {
        model.addAttribute("womenSneakers", womenSneakersService.findAll());
        return "women_sneakers";
    }

    @GetMapping("/kid_sneakers")
    public String kidSneakers(Model model) {
        model.addAttribute("kidSneakers", kidSneakersService.findAll());
        return "kid_sneakers";
    }
}
