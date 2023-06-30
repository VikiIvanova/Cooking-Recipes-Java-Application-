package com.example.demo.controller;

import com.example.demo.dto.CreateRecipeDto;
import com.example.demo.dto.RecipeDto;
import com.example.demo.enums.Category;
import com.example.demo.mapper.CreateRecipeMapper;
import com.example.demo.mapper.RecipeMapper;
import com.example.demo.model.Recipe;
import com.example.demo.model.User;
import com.example.demo.service.RecipeService;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import java.net.MalformedURLException;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final CreateRecipeMapper createRecipeMapper;
    private final RecipeMapper recipeMapper;
    private final UserService userService;

    public RecipeController(RecipeService recipeService, CreateRecipeMapper createRecipeMapper, RecipeMapper recipeMapper, UserService userService) {
        this.recipeService = recipeService;
        this.createRecipeMapper = createRecipeMapper;
        this.recipeMapper = recipeMapper;
        this.userService = userService;
    }

    @GetMapping("/allrecipes")
    public List<RecipeDto> getAllRecipes() {
        final List<Recipe> recipesList = recipeService.getAllRecipes();

        return recipesList.stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/createrecipe")
    public Long createRecipe(@RequestBody CreateRecipeDto recipeDto) {
        System.out.println(recipeDto);
        User user = userService.getUserById(recipeDto.getOwnerId());
        return recipeService.createRecipe(createRecipeMapper.toEntity(recipeDto, user));
    }

    @PutMapping("/{id}")
    public void updateRecipe(@PathVariable("id") Long id, @RequestBody @Valid RecipeDto recipeDto) {
        recipeService.updateRecipe(id, recipeMapper.toEntity(recipeDto));
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable("id") Long id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping("/{id}")
    public RecipeDto getRecipeById(@PathVariable("id") Long id) {
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

    @GetMapping("/{id}/image")
    public Resource getImage(@PathVariable Long id) throws MalformedURLException {
        Recipe recipe = recipeService.getRecipeByID(id);
        File file = new File(recipe.getImagePath());
        Path path = Path.of(file.getAbsolutePath());
        return new UrlResource(path.toUri());
    }


}
