package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "men_sneakers")
public class MenSneakers {
    @Id
    private Long id;

    @OrderColumn(name = "name")
    private String name;
    @OrderColumn(name = "count")
    private Long count;
    @OrderColumn(name = "price")
    private Long price;
    @OrderColumn(name = "discount")
    private Long discount;
    @OrderColumn(name = "gender")
    private String gender;
    @Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;
    // Сохраняем в бд дату
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate;
}
