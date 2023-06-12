package com.example.demo.service;

import com.example.demo.mapper.RecipeMapper;
import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Long createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe).getId();
    }

    public Recipe updateRecipe(Long id, Recipe recipe) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipeToEdit = optionalRecipe.get();
            recipeToEdit.setName(recipe.getName());
            recipeToEdit.setProducts(recipe.getProducts());
            recipeToEdit.setCategory(recipe.getCategory());
            recipeToEdit.setDescription(recipe.getDescription());
            recipeToEdit.setRate(recipe.getRate());
            recipeToEdit.setOwner(recipe.getOwner());
            recipeToEdit.setRecipeLovers(recipe.getRecipeLovers());

            recipeRepository.save(recipeToEdit);
        } else {
            recipeRepository.save(recipe);
        }
        return recipe;
    }

}
