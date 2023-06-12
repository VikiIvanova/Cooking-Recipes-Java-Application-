package com.example.demo.controller;

import com.example.demo.dto.AddRecipeAsFavouriteDto;
import com.example.demo.mapper.RecipeMapper;
import com.example.demo.service.FavouriteRecipesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favouriterecipes")
public class FavouriteRecipesController {
    private final FavouriteRecipesService favouriteRecipesService;

    public FavouriteRecipesController(FavouriteRecipesService favouriteRecipesService, RecipeMapper recipeMapper) {
        this.favouriteRecipesService = favouriteRecipesService;
    }

    @PostMapping("/addrecipetofavourite")
    public Long addRecipeToFavourites(@RequestBody AddRecipeAsFavouriteDto addRecipeAsFavouriteDto) {
        return favouriteRecipesService.addRecipeAsFavourite(
                addRecipeAsFavouriteDto.getRecipeId(),
                addRecipeAsFavouriteDto.getUserId()
        );
    }

    @GetMapping("/allfavouriterecipes/{userId}")
    public List<Long> allFavouriteRecipes(@PathVariable Long userId) {
        return favouriteRecipesService.showAllFavouriteRecipesByUser(userId);
    }


}
