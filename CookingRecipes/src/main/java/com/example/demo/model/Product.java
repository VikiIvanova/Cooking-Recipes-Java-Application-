package com.example.demo.model;

import com.example.demo.enums.Measure;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Column(name = "product_name")
    private String name;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "measure")
    private Measure measure;
}
