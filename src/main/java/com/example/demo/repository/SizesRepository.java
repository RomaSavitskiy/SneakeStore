package com.example.demo.repository;

import com.example.demo.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizesRepository extends JpaRepository<Size, Long> {
}
