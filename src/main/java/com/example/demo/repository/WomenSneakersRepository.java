package com.example.demo.repository;

import com.example.demo.entity.WomenSneakers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WomenSneakersRepository extends JpaRepository<WomenSneakers, Long> {
}
