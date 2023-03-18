package com.example.demo.repository;

import com.example.demo.entity.Sneakers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SneakersRepository extends JpaRepository<Sneakers, Long> {
}
