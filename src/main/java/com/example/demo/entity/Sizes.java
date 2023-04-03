package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sizes")
public class Sizes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "sneakers_id")
    private Sneakers sneakers;

    @Column(name = "37")
    private Long size37;

    @Column(name = "38")
    private Long size38;

    @Column(name = "39")
    private Long size39;

    @Column(name = "40")
    private Long size40;

    @Column(name = "41")
    private Long size41;

    @Column(name = "42")
    private Long size42;

    @Column(name = "43")
    private Long size43;

    @Column(name = "44")
    private Long size44;

    @Column(name = "45")
    private Long size45;
}
