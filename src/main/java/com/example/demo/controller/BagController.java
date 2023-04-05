package com.example.demo.controller;

import com.example.demo.entity.Sneakers;
import com.example.demo.service.SneakersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BagController {
    private final SneakersService sneakersService;

    @GetMapping("/bag")
    public String bag(HttpSession session){
        List<Sneakers> sneakersList = (List<Sneakers>) session.getAttribute("bagSneakersList");
        double totalPrice = sneakersList.stream().
                mapToDouble(sneakers -> sneakers.getPrice().doubleValue() *
                        ((100.0d - sneakers.getDiscount().doubleValue()) / 100.0d)).sum();
        log.info("Total price: {}", totalPrice);
        session.setAttribute("totalPrice", (int)totalPrice);

        return "bagPage";
    }

    @GetMapping("/addProductToBag")
    public String addProductToBag(@RequestParam("size") Long size,
                                  HttpSession session,
                                  @RequestParam("productId") String id)  {

        log.info("Our size: {}", size);
        List<Sneakers> bagSneakers = (List<Sneakers>) session.getAttribute("bagSneakersList");
        bagSneakers.add(sneakersService.findById(Long.valueOf(id)));
        session.setAttribute("bagSneakersList", bagSneakers);
        session.setAttribute("sneakerSize", size);

        return "redirect:/products";
    }
}
