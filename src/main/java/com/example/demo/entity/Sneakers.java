package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "all_sneakers")
public class Sneakers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OrderColumn(name = "name")
    private String name;
    @OrderColumn(name = "count")
    private Long count;
    @OrderColumn(name = "price")
    private Long price;
    @OrderColumn(name = "discount")
    private Long discount;
    // Эта аннотация означает, что может хранится большой файл
    @Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;
    // Сохраняем в бд дату
    /*@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate;*/
}
