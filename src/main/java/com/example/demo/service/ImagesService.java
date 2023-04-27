package com.example.demo.service;

import com.example.demo.entity.Image;
import com.example.demo.entity.Sneakers;
import com.example.demo.repository.ImagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagesService {
    private final ImagesRepository imagesRepository;

/*    public List<Image> findBySneaker() {
        return imagesRepository.findBySneakerId();
    }*/

    public Image findFirstForSneaker(Long id) {
        return imagesRepository.findAllImagesForSneaker(id).get(0);
    }

    public void save(Image image) {
        imagesRepository.save(image);
    }

    public List<Image> findAll() {
        return imagesRepository.findAll();
    }

    public Image findById(Long id) {
        return imagesRepository.findById(id).orElseThrow();
    }

    public List<Image> findAllImagesForSneaker(Long id) {
        return imagesRepository.findAllImagesForSneaker(id);
    }

    public void saveImageList(List<MultipartFile> images, Sneakers sneakers) throws IOException {
        for (MultipartFile image : images) {
            Image newImage = new Image();
            newImage.setImage(image.getBytes());
            newImage.setSneakers(sneakers);
            sneakers.getImages().add(newImage);
            save(newImage);
        }
    }
}
