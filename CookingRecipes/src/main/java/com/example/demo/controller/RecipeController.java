package com.example.demo.controller;

import com.example.demo.dto.RecipeDto;
import com.example.demo.mapper.RecipeMapper;
import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;

    public RecipeController(RecipeService recipeService, RecipeMapper recipeMapper) {
        this.recipeService = recipeService;
        this.recipeMapper = recipeMapper;
    }

    @GetMapping
    public List<RecipeDto> getAllRecipes() {
        final List<Recipe> recipesList = recipeService.getAllRecipes();

        return recipesList.stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Long createRecipe(@RequestBody RecipeDto recipe) {
        return recipeService.createRecipe(recipeMapper.toEntity(recipe));
    }
}
