package com.example.demo.controller;

import com.example.demo.dto.CreateRecipeDto;
import com.example.demo.mapper.RecipeMapper;
import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import jakarta.validation.Valid;
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

    @GetMapping("/allrecipes")
    public List<CreateRecipeDto> getAllRecipes() {
        final List<Recipe> recipesList = recipeService.getAllRecipes();

        return recipesList.stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/createrecipe")
    public Long createRecipe(@RequestBody CreateRecipeDto recipeDto) {
        return recipeService.createRecipe(recipeMapper.toEntity(recipeDto));
    }

    @PutMapping("/{id}")
    public void updateRecipe(@PathVariable Long id, @RequestBody @Valid CreateRecipeDto recipeDto) {
        recipeService.updateRecipe(id, recipeMapper.toEntity(recipeDto));
    }

}
