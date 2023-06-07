package com.example.demo.controller;

import com.example.demo.dto.CreateRecipeDto;
import com.example.demo.dto.RecipeDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.RecipeDto;
import com.example.demo.enums.Category;
import com.example.demo.mapper.CreateRecipeMapper;
import com.example.demo.mapper.RecipeMapper;
import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final CreateRecipeMapper createRecipeMapper;
    private final RecipeMapper recipeMapper;

    public RecipeController(RecipeService recipeService, CreateRecipeMapper createRecipeMapper, RecipeMapper recipeMapper) {
        this.recipeService = recipeService;
        this.createRecipeMapper = createRecipeMapper;
        this.recipeMapper = recipeMapper;
    }

    @GetMapping("/allrecipes")
    public List<CreateRecipeDto> getAllRecipes() {
        final List<Recipe> recipesList = recipeService.getAllRecipes();

        return recipesList.stream()
                .map(createRecipeMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/createrecipe")
    public Long createRecipe(@RequestBody CreateRecipeDto recipeDto) {
        return recipeService.createRecipe(createRecipeMapper.toEntity(recipeDto));
    }

    @PutMapping("/{id}")
    public void updateRecipe(@PathVariable("id") Long id, @RequestBody @Valid CreateRecipeDto recipeDto) {
        recipeService.updateRecipe(id, createRecipeMapper.toEntity(recipeDto));
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable("id") Long id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping("/{id}")
    public RecipeDto getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    @GetMapping("/search")
    public List<RecipeDto> searchRecipes(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "category", required = false) Category category,
            @RequestParam(value = "productName", required = false) String productName
    ) {
        List<Recipe> recipes = recipeService.searchRecipes(name, category, productName);
        return recipes.stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

}
