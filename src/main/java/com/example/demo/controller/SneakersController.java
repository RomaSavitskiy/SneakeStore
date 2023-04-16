package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.ImagesService;
import com.example.demo.service.SizesService;
import com.example.demo.service.SneakersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/sneakers")
@RequiredArgsConstructor
@Controller
@Slf4j
public class SneakersController {
    private final SneakersService sneakersService;
    private final ImagesService imagesService;
    private final SizesService sizesService;

    @GetMapping
    public String showSneakers(Model model) {
        model.addAttribute("sneakers", sneakersService.findAll());
        List<Sneakers> sneakers = sneakersService.findAll();
        return "products";
    }

    @GetMapping("/men")
    public String showMenSneakers(Model model) {
        model.addAttribute("sneakers", sneakersService.findAllByGender("men"));
        return "products";
    }

    @GetMapping("/women")
    public String showWomenSneakers(Model model) {
        model.addAttribute("sneakers", sneakersService.findAllByGender("women"));
        return "products";
    }

    @GetMapping("/discount")
    public String discountSneakers(Model model) {
        model.addAttribute("sneakers",sneakersService.findAllWithDiscount());
        return "products";
    }

    @GetMapping("/{id}")
    public String product(@PathVariable Long id, Model model) {
        Sneakers sneaker = sneakersService.findById(id);
        model.addAttribute("product", sneaker);
        model.addAttribute("productImages", imagesService.findAllImagesForSneaker(id));

        return "product";
    }

    @PostMapping("/add")
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
        sizesService.save(sizes);


        for(int i = 0; i < images.size(); i++) {
            Images newImages = new Images();

            newImages.setImage(images.get(i).getBytes());
            newImages.setSneakers(sneakers);
            sneakers.getImages().add(newImages);
            imagesService.save(newImages);
        }

        return "redirect:/adminMenu";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("sneakerId") Long id, Model model) {
        log.info("Product with id {} was deleted", id);

        List<Long> idList = sneakersService.findAllId();

        if (!idList.contains(id)) {
            model.addAttribute("deleteResult", "Product with this ID is not found");
            model.addAttribute("sneakers", sneakersService.findAll());
            return "adminPage";
        }

        sneakersService.deleteById(id);
        model.addAttribute("deleteResult", "Success delete");
        model.addAttribute("sneakers", sneakersService.findAll());

        return "adminPage";
    }
}
