package com.example.demo.service;

import com.example.demo.entity.Sizes;
import com.example.demo.repository.SizesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizesService {
    private final SizesRepository sizesRepository;

    public List<Sizes> findAll() {
        return sizesRepository.findAll();
    }

    public void save(Sizes sizes) {
        sizesRepository.save(sizes);
    }
}
