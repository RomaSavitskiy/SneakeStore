package com.example.demo.controller;

import com.example.demo.entity.Images;
import com.example.demo.entity.Sizes;
import com.example.demo.entity.Sneakers;
import com.example.demo.repository.SizesRepository;
import com.example.demo.service.ImagesService;
import com.example.demo.service.SneakersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final SizesRepository sizesRepository;

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
                             @RequestParam("price") Long price,
                             @RequestParam("image") List<MultipartFile> images,
                             @RequestParam("gender") String gender,
                             @RequestParam("size37") String size37,
                             @RequestParam("size38") String size38,
                             @RequestParam("size39") String size39,
                             @RequestParam("size40") String size40,
                             @RequestParam("size41") String size41,
                             @RequestParam("size42") String size42,
                             @RequestParam("size43") String size43,
                             @RequestParam("size44") String size44,
                             @RequestParam("size45") String size45) throws IOException {

        Sneakers sneakers = sneakersService.setSneakersBody(name, discount, price, gender);
        sneakersService.save(sneakers);

        Sizes sizes = new Sizes();
        sizes.setSize37(Long.valueOf(size37));
        sizes.setSize38(Long.valueOf(size38));
        sizes.setSize39(Long.valueOf(size39));
        sizes.setSize40(Long.valueOf(size40));
        sizes.setSize41(Long.valueOf(size41));
        sizes.setSize42(Long.valueOf(size42));
        sizes.setSize43(Long.valueOf(size43));
        sizes.setSize44(Long.valueOf(size44));
        sizes.setSize45(Long.valueOf(size45));
        sizes.setSneakers(sneakers);
        sneakers.setSizes(sizes);
        sizesRepository.save(sizes);


        for(int i = 0; i < images.size(); i++) {
            Images newImage = new Images();

            newImage.setImage(images.get(i).getBytes());
            newImage.setSneakers(sneakers);
            sneakers.getImages().add(newImage);
            imagesService.save(newImage);
        }

        return "redirect:/adminMenu";
    }

    @GetMapping(value = "/products")
    public String showSneakers(Model model) {
        model.addAttribute("sneakers", sneakersService.findAll());
        /*model.addAttribute("sneakerImages", imagesService.findAll());*/
        List<Sneakers> sneakers = sneakersService.findAll();
        /*sneakers.get(0).getImages();*/
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
