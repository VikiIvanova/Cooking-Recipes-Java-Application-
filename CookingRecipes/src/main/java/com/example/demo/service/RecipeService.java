package com.example.demo.service;

import com.example.demo.dto.RecipeDto;
import com.example.demo.enums.Category;
import com.example.demo.mapper.CreateRecipeMapper;
import com.example.demo.mapper.RecipeMapper;
import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    private final CreateRecipeMapper createRecipeMapper;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, CreateRecipeMapper createRecipeMapper, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.createRecipeMapper = createRecipeMapper;
        this.recipeMapper = recipeMapper;
    }

    public List<Recipe> getAllRecipes(){
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

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public RecipeDto getRecipeById(Long id) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            return recipeMapper.toDto(recipe);
        } else {
           return null;
        }
    }

    public List<Recipe> searchRecipes(String name, Category category, String productName) {
        if (productName != null && !productName.isEmpty()) {
            return recipeRepository.findByNameAndCategoryAndProducts_Name(name, category, productName);
        }
        return recipeRepository.findByNameAndCategory(name, category);
    }

}
