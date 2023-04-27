package com.example.demo.repository;

import com.example.demo.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImagesRepository extends JpaRepository<Image, Long> {
    @Query("SELECT i FROM Image i WHERE i.sneakers.id = ?1")
    public Image findFirstForSneaker(Long id);

    @Query("SELECT u FROM Image u WHERE u.sneakers.id = ?1")
    public List<Image> findAllImagesForSneaker(Long id);
}
