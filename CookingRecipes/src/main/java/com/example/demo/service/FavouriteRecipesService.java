package com.example.demo.service;

import com.example.demo.dto.FavouriteRecipesDto;
import com.example.demo.model.FavouriteRecipe;
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
    FavouriteRecipesService(FavoriteRecipesRepository favoriteRecipesRepository, RecipeRepository recipeRepository, UserRepository userRepository, UserRepository userRepository1, RecipeRepository recipeRepository1) {
        this.favoriteRecipesRepository = favoriteRecipesRepository;
        this.userRepository = userRepository1;
        this.recipeRepository = recipeRepository1;
    }

    public void addRecipeToFavourites(FavouriteRecipe favouriteRecipe) {
        favoriteRecipesRepository.save(favouriteRecipe);
    }

    /*
    public List<Recipe> showAllFavouriteRecipesByUser(User user) {
        /*
        Optional<User> userOptional = userRepository.findById(userId);
        User user = new User();
        if(userOptional.isPresent()){
            user = userOptional.get();
        }
        return new ArrayList<>(user.getFavourites());


        Optional<FavouriteRecipe> favouriteRecipe = favoriteRecipesRepository.
    }

    public List<User> showAllRecipeLovers(Long recipeId){
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        Recipe recipe = new Recipe();
        if(recipeOptional.isPresent()){
            recipe = recipeOptional.get();
        }
        return new ArrayList<>(recipe.getRecipeLovers());
    }
    */
}
