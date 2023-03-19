package com.example.demo.service;

import com.example.demo.entity.MenSneakers;
import com.example.demo.entity.Sneakers;
import com.example.demo.entity.WomenSneakers;
import com.example.demo.repository.MenSneakersRepository;
import com.example.demo.repository.WomenSneakersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WomenSneakersService {
    private final WomenSneakersRepository womenSneakersRepository;

    public List<WomenSneakers> findAll() {
        return womenSneakersRepository.findAll();
    }

    public WomenSneakers findById(Long id) {
        return womenSneakersRepository.findById(id).orElseThrow();
    }

    public void save(WomenSneakers menSneakers) {
        womenSneakersRepository.save(menSneakers);
    }

    public WomenSneakers setWomenSneakersBody(WomenSneakers womenSneakers, Sneakers sneakers) {
        womenSneakers.setId(sneakers.getId());
        womenSneakers.setName(sneakers.getName());
        womenSneakers.setPrice(sneakers.getPrice());
        womenSneakers.setImage(sneakers.getImage());
        womenSneakers.setCount(sneakers.getCount());
        womenSneakers.setDiscount(sneakers.getDiscount());
        womenSneakers.setCreateDate(new Date());
        womenSneakers.setGender(sneakers.getGender());

        return womenSneakers;
    }
}
