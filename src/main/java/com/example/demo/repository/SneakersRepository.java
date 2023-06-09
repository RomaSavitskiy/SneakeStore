package com.example.demo.repository;

import com.example.demo.entity.Sneakers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SneakersRepository extends JpaRepository<Sneakers, Long> {
    @Query("SELECT u FROM Sneakers u WHERE u.gender = ?1")
    List<Sneakers> findByGender(String gender);

    @Query("FROM Sneakers ")
    Page<Sneakers> getPage(Pageable pageable);

    @Query("SELECT u FROM Sneakers u WHERE u.discount > 0")
    List<Sneakers> findAllWithDiscount();

    @Query("SELECT id FROM Sneakers")
    List<Long> findAllId();
}
