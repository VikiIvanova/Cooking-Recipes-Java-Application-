package com.example.demo.controller;

import com.example.demo.dto.AddFavouriteRecipeDto;
import com.example.demo.mapper.RecipeMapper;
import com.example.demo.service.FavouriteRecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favouriterecipes")
public class FavouriteRecipeController {
    private final FavouriteRecipeService favouriteRecipesService;

    public FavouriteRecipeController(FavouriteRecipeService favouriteRecipesService, RecipeMapper recipeMapper) {
        this.favouriteRecipesService = favouriteRecipesService;
    }


    @PostMapping("/addrecipetofavourite")
    public Long addRecipeToFavourites(@RequestBody AddFavouriteRecipeDto addRecipeAsFavouriteDto) {
        Long recipeId = addRecipeAsFavouriteDto.getRecipeId();
        Long userId = addRecipeAsFavouriteDto.getUserId();

        if (favouriteRecipesService.isRecipeInFavorites(recipeId, userId)) {
            return -1L;
        }
        return favouriteRecipesService.addRecipeAsFavourite(recipeId, userId);
    }


    @GetMapping("/allfavouriterecipes/{userId}")
    public List<Long> allFavouriteRecipes(@PathVariable Long userId) {
        return favouriteRecipesService.showAllFavouriteRecipesByUser(userId);
    }


}
