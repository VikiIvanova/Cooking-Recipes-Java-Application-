package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.demo.enums.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipe")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "product_quantity")
    @MapKeyColumn(name = "product_name")
    private Set<Product> products = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String description;

    @Column
    private String imagePath;

    @Column
    private Double rate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner")
    private User owner;

    @OneToMany(mappedBy = "recipe")
    private Set<FavouriteRecipe> recipeLovers = new HashSet<>();
}

