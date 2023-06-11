package com.example.demo.dto;

import com.example.demo.enums.Category;

import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
    private Long id;
    private String name;
    private Set<ProductDto> products = new HashSet<>();
    private Category category;
    private String description;
    private Double rate;
    private User owner;
    private Set<User> recipeLovers = new HashSet<>();
}