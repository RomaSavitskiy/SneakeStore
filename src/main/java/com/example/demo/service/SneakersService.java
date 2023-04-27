package com.example.demo.service;

import com.example.demo.entity.Size;
import com.example.demo.entity.Sneakers;
import com.example.demo.repository.SneakersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SneakersService {
    private final SneakersRepository sneakersRepository;
    private final SizesService sizesService;
    private final ImagesService imagesService;
    public List<Sneakers> findAll() {
        return sneakersRepository.findAll();
    }

    public void deleteById(Long id) {
        sneakersRepository.deleteById(id);
    }

    public Sneakers findById(Long id) {
        return sneakersRepository.findById(id).orElseThrow();
    }
    public void save(String name,
                     Long discount,
                     Long price,
                     List<MultipartFile> images,
                     String gender,
                     String size37, String size38, String size39,
                     String size40, String size41, String size42,
                     String size43, String size44, String size45) throws IOException {

        Sneakers sneakers = setSneakersFields(name, discount, price, gender);
        sneakersRepository.save(sneakers);

        Size size = new Size();
        sizesService.save(sizesService.setAllArguments(size, sneakers, size37, size38, size39,
                                                        size40, size41, size42, size43, size44, size45));

        imagesService.saveImageList(images, sneakers);
    }

    public Sneakers setSneakersFields(String name,
                                      Long discount,
                                      Long price,
                                      String gender) throws IOException {

        Sneakers sneakers = new Sneakers();
        sneakers.setName(name);
        sneakers.setPrice(price);
        sneakers.setDiscount(discount);
        sneakers.setCreateDate(new Date());
        sneakers.setGender(gender);

        return sneakers;
    }

    public List<Sneakers> findAllByGender(String gender) {
        return sneakersRepository.findByGender(gender);
    }

    public List<Sneakers> findAllWithDiscount() {
        return sneakersRepository.findAllWithDiscount();
    }

    public List<Long> findAllId() {
        return sneakersRepository.findAllId();
    }
}
