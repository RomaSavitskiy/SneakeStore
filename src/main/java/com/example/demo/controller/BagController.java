package com.example.demo.controller;

import com.example.demo.entity.Sneakers;
import com.example.demo.service.SneakersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bag")
@RequiredArgsConstructor
@Slf4j
public class BagController {
    private final SneakersService sneakersService;

    @GetMapping
    public String bag(HttpSession session){
        List<Sneakers> sneakersList = (List<Sneakers>) session.getAttribute("bagSneakersList");
        double totalPrice = sneakersList.stream().
                mapToDouble(sneakers -> sneakers.getPrice().doubleValue() *
                        ((100.0d - sneakers.getDiscount().doubleValue()) / 100.0d)).sum();
        log.info("Total price: {}", totalPrice);
        session.setAttribute("totalPrice", (int)totalPrice);

        return "bag";
    }

    @GetMapping("/product")
    public String addProductToBag(@RequestParam("size") Long size,
                                  HttpSession session,
                                  @RequestParam("productId") String id)  {
        List<Sneakers> bagSneakers = (List<Sneakers>) session.getAttribute("bagSneakersList");
        bagSneakers.add(sneakersService.findById(Long.valueOf(id)));
        session.setAttribute("bagSneakersList", bagSneakers);
        session.setAttribute("sneakerSize", size);

        return "redirect:/sneakers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, HttpSession session) {
        List<Sneakers> sneakersList = (List<Sneakers>) session.getAttribute("bagSneakersList");

        sneakersList = sneakersList.stream().filter(sneakers -> !Objects.equals(sneakers.getId(), id)).collect(Collectors.toList());
        session.setAttribute("bagSneakersList", sneakersList);

        return "redirect:/bag";
    }
}
