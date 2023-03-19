package com.example.demo.service;

import com.example.demo.entity.KidSneakers;
import com.example.demo.entity.MenSneakers;
import com.example.demo.entity.Sneakers;
import com.example.demo.repository.KidSneakersRepository;
import com.example.demo.repository.MenSneakersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KidSneakersService {
    private final KidSneakersRepository kidSneakersRepository;

    public List<KidSneakers> findAll() {
        return kidSneakersRepository.findAll();
    }

    public KidSneakers findById(Long id) {
        return kidSneakersRepository.findById(id).orElseThrow();
    }

    public void save(KidSneakers kidSneakers) {
        kidSneakersRepository.save(kidSneakers);
    }

    public KidSneakers setKidSneakersBody(KidSneakers kidSneakers, Sneakers sneakers) {
        kidSneakers.setId(sneakers.getId());
        kidSneakers.setName(sneakers.getName());
        kidSneakers.setPrice(sneakers.getPrice());
        kidSneakers.setImage(sneakers.getImage());
        kidSneakers.setCount(sneakers.getCount());
        kidSneakers.setDiscount(sneakers.getDiscount());
        kidSneakers.setCreateDate(new Date());
        kidSneakers.setGender(sneakers.getGender());

        return kidSneakers;
    }
}
