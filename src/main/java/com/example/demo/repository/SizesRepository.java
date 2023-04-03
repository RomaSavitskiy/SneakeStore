package com.example.demo.repository;

import com.example.demo.entity.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizesRepository extends JpaRepository<Sizes, Long> {
}
