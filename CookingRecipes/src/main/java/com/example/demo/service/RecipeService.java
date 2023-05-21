package com.example.demo.service;

import com.example.demo.mapper.RecipeMapper;
import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll();
    }

    public Long createRecipe(Recipe recipe) {
       return recipeRepository.save(recipe).getId();
    }

}
