package com.example.demo.model;

import com.example.demo.enums.Measure;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Column(name = "product_name")
    private String name;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "measure")
    private Measure measure;
}
