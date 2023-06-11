package com.example.demo.controller;

import com.example.demo.dto.FavouriteRecipesDto;
import com.example.demo.mapper.FavouriteRecipeMapper;
import com.example.demo.service.FavouriteRecipesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favouriterecipes")
public class FavouriteRecipesController {
    private final FavouriteRecipesService favouriteRecipesService;
    private final FavouriteRecipeMapper favouriteRecipeMapper;

    public FavouriteRecipesController(FavouriteRecipesService favouriteRecipesService, FavouriteRecipeMapper favouriteRecipeMapper) {
        this.favouriteRecipesService = favouriteRecipesService;
        this.favouriteRecipeMapper = favouriteRecipeMapper;
    }

    @PostMapping("/addrecipetofavourite")
    public void addRecipeToFavourites(@RequestBody FavouriteRecipesDto favouriteRecipesDto) {
       favouriteRecipesService.addRecipeToFavourites(favouriteRecipeMapper.toEntity(favouriteRecipesDto));
    }
    /*

    @GetMapping("/allfavouriterecipes/{userId}")
    public List<RecipeDto> allFavouriteRecipes(@PathVariable Long userId){
        List<RecipeDto> recipeDto = new ArrayList<>();
        for(Recipe recipe : favouriteRecipesService.showAllFavouriteRecipes(userId)){
            recipeDto.add(recipeMapper.toRecipeDto(recipe));
        }
        return recipeDto;
    }

    @GetMapping("/allrecipelovers/{recipeId}")
    public List<UserDto> allRecipeLover(@PathVariable Long recipeId){
        List<UserDto> userDto = new ArrayList<>();
        for(User user : favouriteRecipesService.showAllRecipeLovers(recipeId)){
            userDto.add(userMapper.toUserDto(user));
        }
        return userDto;
    }
     */


}
