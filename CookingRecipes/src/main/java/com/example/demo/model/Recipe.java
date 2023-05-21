package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Pair;

import com.example.demo.enums.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    private Long id;

    private String name;

    @Transient
    private Map<String, Pair<Double, Quantity>> products = new HashMap<>();


    @Transient
    private Category category;


    private String description;


    private Double rate;


    private int userId;
}

