package com.example.demo.service;

import com.example.demo.entity.Images;
import com.example.demo.repository.ImagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagesService {
    private final ImagesRepository imagesRepository;

    public List<Images> findBySneaker() {
        return imagesRepository.findBySneakerId();
    }

    public Images findFirstForSneaker(Long id) {
        return imagesRepository.findFirstForSneaker(id);
    }

    public void save(Images images) {
        imagesRepository.save(images);
    }

    public List<Images> findAll() {
        return imagesRepository.findAll();
    }

    public Images findById(Long id) {
        return imagesRepository.findById(id).orElseThrow();
    }
}
