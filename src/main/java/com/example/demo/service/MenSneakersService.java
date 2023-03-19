package com.example.demo.service;

import com.example.demo.entity.MenSneakers;
import com.example.demo.entity.Sneakers;
import com.example.demo.repository.MenSneakersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenSneakersService {
    private final MenSneakersRepository menSneakersRepository;

    public List<MenSneakers> findAll() {
        return menSneakersRepository.findAll();
    }

    public MenSneakers findById(Long id) {
        return menSneakersRepository.findById(id).orElseThrow();
    }

    public void save(MenSneakers menSneakers) {
        menSneakersRepository.save(menSneakers);
    }

    public MenSneakers setMenSneakersBody(MenSneakers menSneakers, Sneakers sneakers) {
        menSneakers.setId(sneakers.getId());
        menSneakers.setName(sneakers.getName());
        menSneakers.setPrice(sneakers.getPrice());
        menSneakers.setImage(sneakers.getImage());
        menSneakers.setCount(sneakers.getCount());
        menSneakers.setDiscount(sneakers.getDiscount());
        menSneakers.setCreateDate(new Date());
        menSneakers.setGender(sneakers.getGender());

        return menSneakers;
    }
}
