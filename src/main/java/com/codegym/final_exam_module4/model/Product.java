package com.codegym.final_exam_module4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private String status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
