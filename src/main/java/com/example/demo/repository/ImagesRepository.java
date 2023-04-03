package com.example.demo.repository;

import com.example.demo.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImagesRepository extends JpaRepository<Images, Long> {
    @Query("SELECT u FROM Images u WHERE u.sneakers = ?1")
    public List<Images> findBySneakerId();

    @Query("SELECT i FROM Images i WHERE i.sneakers.id = ?1")
    public Images findFirstForSneaker(Long id);

    @Query("SELECT u FROM Images u WHERE u.sneakers.id = ?1")
    public List<Images> findAllImagesForSneaker(Long id);
}
