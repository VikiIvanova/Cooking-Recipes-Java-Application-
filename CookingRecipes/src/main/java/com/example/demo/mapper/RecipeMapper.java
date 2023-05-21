package com.example.demo.mapper;

import com.example.demo.dto.RecipeDto;
import com.example.demo.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {

    public RecipeDto toDto(Recipe entity) {
        return RecipeDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .products(entity.getProducts())
                .category(entity.getCategory())
                .description(entity.getDescription())
                .rate(entity.getRate())
                .userId(entity.getUserId())
                .build();
    }

    public Recipe toEntity(RecipeDto dto) {
        return Recipe.builder()
                .id(dto.getId())
                .name(dto.getName())
                .products(dto.getProducts())
                .category(dto.getCategory())
                .description(dto.getDescription())
                .rate(dto.getRate())
                .userId(dto.getUserId())
                .build();
    }
}
