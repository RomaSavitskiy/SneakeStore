package com.example.demo.repository;

import com.example.demo.entity.Sneakers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SneakersRepository extends JpaRepository<Sneakers, Long> {
    @Query("SELECT u FROM Sneakers u WHERE u.gender = ?1")
    List<Sneakers> findByGender(String gender);
}
