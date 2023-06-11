package com.example.demo.service;


import com.example.demo.model.FavouriteRecipes;
import com.example.demo.model.Recipe;
import com.example.demo.model.User;
import com.example.demo.repository.FavoriteRecipesRepository;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FavouriteRecipesService {
    private final FavoriteRecipesRepository favoriteRecipesRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    @Autowired
    FavouriteRecipesService(FavoriteRecipesRepository favoriteRecipesRepository, UserRepository userRepository, RecipeRepository recipeRepository) {
        this.favoriteRecipesRepository = favoriteRecipesRepository;
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    public Long addRecipeAsFavourite(Long recipeId, Long userId) {
        Recipe recipe = new Recipe();
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if(recipeOptional.isPresent()){
            recipe = recipeOptional.get();
        }
        User user = new User();
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        FavouriteRecipes favouriteRecipe = new FavouriteRecipes();
        favouriteRecipe.setUser(user);
        favouriteRecipe.setRecipe(recipe);
        return favoriteRecipesRepository.save(favouriteRecipe).getId();
    }



    public List<Recipe> showAllFavouriteRecipesByUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        User user = new User();
        if(userOptional.isPresent()){
            user = userOptional.get();
        }

        List<Recipe> recipes = new ArrayList<>();
        for(FavouriteRecipes favouriteRecipe : user.getFavourites()){
            recipes.add(favouriteRecipe.getRecipe());
        }
        return recipes;
    }


}

