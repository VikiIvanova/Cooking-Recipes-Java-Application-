package com.example.demo.mapper;

import com.example.demo.dto.FavouriteRecipesDto;
import com.example.demo.model.FavouriteRecipes;
import org.springframework.stereotype.Component;

@Component
public class FavouriteRecipesMapper {
    public FavouriteRecipes toEntity(FavouriteRecipesDto dto) {
        return FavouriteRecipes.builder()
                .user(dto.getUser())
                .recipe(dto.getRecipe())
                .build();
    }
}
