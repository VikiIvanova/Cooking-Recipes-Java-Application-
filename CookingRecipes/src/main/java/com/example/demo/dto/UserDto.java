package com.example.demo.dto;

import com.example.demo.model.FavouriteRecipes;
import com.example.demo.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Set<Recipe> recipes = new HashSet<>();
    private Set<FavouriteRecipes> favourites = new HashSet<>();
}
