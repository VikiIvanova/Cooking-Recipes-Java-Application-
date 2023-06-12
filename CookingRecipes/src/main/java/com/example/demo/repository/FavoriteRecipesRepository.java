package com.example.demo.repository;

import com.example.demo.model.FavouriteRecipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRecipesRepository extends JpaRepository<FavouriteRecipes, Long> {
}
