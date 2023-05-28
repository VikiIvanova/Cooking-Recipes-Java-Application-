package com.example.demo.model;

import com.example.demo.enums.Measure;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

@Embeddable
public class Product {
    @Column(name = "product_name")
    private String name;

    @Transient
    private Measure measure;
    @Transient
    private Double quantity;

    @Column(name = "product_quantity")
    private String quantityWithMeasure;

    public Product(String name, Double quantity, Measure measure){
        this.measure = measure;
        this.quantity = quantity;
        this.name = name;
        this.quantityWithMeasure = quantity.toString() + measure.getMeasureName();
    }
}
