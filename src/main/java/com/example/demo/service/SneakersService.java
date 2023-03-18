package com.example.demo.service;

import com.example.demo.entity.Sneakers;
import com.example.demo.repository.SneakersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SneakersService {
    private final SneakersRepository sneakersRepository;
    public List<Sneakers> findAll() {
        return sneakersRepository.findAll();
    }

    public Sneakers findById(Long id) {
        return sneakersRepository.findById(id).orElseThrow();
    }
    public void save(Sneakers sneakers) {
        sneakersRepository.save(sneakers);
    }
}
