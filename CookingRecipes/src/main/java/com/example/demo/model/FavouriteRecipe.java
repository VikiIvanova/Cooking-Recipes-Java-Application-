package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Entity (name = "favourite_recipes")
@Data
@Builder
public class FavouriteRecipe {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Long recipeId;
}
