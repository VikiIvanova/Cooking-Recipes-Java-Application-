package com.example.demo.repository;

import com.example.demo.model.FavouriteRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRecipeRepository extends JpaRepository<FavouriteRecipe, Long> {
}
