package com.example.demo.mapper;

import com.example.demo.dto.FavouriteRecipesDto;
import com.example.demo.model.FavouriteRecipe;

public class FavouriteRecipeMapper {
    public FavouriteRecipe toEntity(FavouriteRecipesDto dto) {
        return FavouriteRecipe.builder()
                .userId(dto.getUserId())
                .recipeId(dto.getRecipeId())
                .build();
    }
}
