package com.example.demo.entity;

import com.example.demo.enums.SizeEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sizes")
public class Size {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sneakers_id")
    private Sneakers sneakers;

    @Column(name = "size")
    private SizeEnum size;

    @Column(name = "count")
    private Long count;
}
