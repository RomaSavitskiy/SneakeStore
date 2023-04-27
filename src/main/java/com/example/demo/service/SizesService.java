package com.example.demo.service;

import com.example.demo.entity.Size;
import com.example.demo.entity.Sneakers;
import com.example.demo.repository.SizesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizesService {
    private final SizesRepository sizesRepository;

    public List<Size> findAll() {
        return sizesRepository.findAll();
    }

    public void save(Size size) {
        sizesRepository.save(size);
    }

    public Size setAllArguments(Size size, Sneakers sneakers,
                                String size37, String size38, String size39,
                                String size40, String size41, String size42,
                                String size43, String size44, String size45) {
        size.setSize37(Long.valueOf(size37));
        size.setSize38(Long.valueOf(size38));
        size.setSize39(Long.valueOf(size39));
        size.setSize40(Long.valueOf(size40));
        size.setSize41(Long.valueOf(size41));
        size.setSize42(Long.valueOf(size42));
        size.setSize43(Long.valueOf(size43));
        size.setSize44(Long.valueOf(size44));
        size.setSize45(Long.valueOf(size45));
        size.setSneakers(sneakers);
        sneakers.setSize(size);

        return size;
    }
}
