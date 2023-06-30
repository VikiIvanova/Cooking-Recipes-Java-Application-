package com.example.demo.dto;

import com.example.demo.model.Recipe;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteRecipesDto {
    private User user;
    private Recipe recipe;
}

