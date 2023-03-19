package com.example.demo.service;

import com.example.demo.entity.Sneakers;
import com.example.demo.entity.WomenSneakers;
import com.example.demo.repository.SneakersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
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

    public Sneakers setSneakersBody(String name,
                                    Long discount,
                                    Long count,
                                    Long price,
                                    MultipartFile image,
                                    String gender) throws IOException {

        Sneakers sneakers = new Sneakers();
        sneakers.setName(name);
        sneakers.setPrice(price);
        sneakers.setImage(image.getBytes());
        sneakers.setCount(count);
        sneakers.setDiscount(discount);
        sneakers.setCreateDate(new Date());
        sneakers.setGender(gender);

        return sneakers;
    }
}
