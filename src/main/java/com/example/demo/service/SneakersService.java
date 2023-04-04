package com.example.demo.service;

import com.example.demo.entity.Sneakers;
import com.example.demo.repository.SneakersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SneakersService {
    private final SneakersRepository sneakersRepository;
    public List<Sneakers> findAll() {
        return sneakersRepository.findAll();
    }

    public void deleteById(Long id) {
        sneakersRepository.deleteById(id);
    }

    public Sneakers findById(Long id) {
        return sneakersRepository.findById(id).orElseThrow();
    }
    public void save(Sneakers sneakers) {
        sneakersRepository.save(sneakers);
    }

    public Sneakers setSneakersBody(String name,
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
