package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "all_sneakers")
public class Sneakers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OrderColumn(name = "name")
    private String name;

    @OrderColumn(name = "price")
    private Long price;

    @OrderColumn(name = "discount")
    private Long discount;

    @OrderColumn(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "sneakers", cascade = CascadeType.PERSIST)
    private List<Images> images = new ArrayList<>();

    @OneToOne(mappedBy = "sneakers", cascade = CascadeType.PERSIST)
    private Sizes sizes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate;
}
