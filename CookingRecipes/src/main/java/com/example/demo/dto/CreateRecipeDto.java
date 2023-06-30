package com.example.demo.dto;

import com.example.demo.enums.Category;
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
public class CreateRecipeDto {
    private String name;
    private Set<ProductDto> products = new HashSet<>();
    private Category category;
    private String description;
    private String imagePath;
    private Double rate;
    private Long ownerId;
}
