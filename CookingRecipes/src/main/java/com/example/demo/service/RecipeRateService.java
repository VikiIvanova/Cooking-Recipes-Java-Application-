package com.example.demo.service;

import com.example.demo.model.Recipe;
import com.example.demo.model.RecipeRate;
import com.example.demo.model.User;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.repository.RecipeRateRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeRateService {
    private final RecipeRateRepository recipeReteRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    @Autowired
    RecipeRateService(RecipeRateRepository recipeReteRepository, UserRepository userRepository, RecipeRepository recipeRepository) {
        this.recipeReteRepository = recipeReteRepository;
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    public Long addRecipeRate(Long recipeId, Long userId, Double rate) {
        Recipe recipe = new Recipe();
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if (recipeOptional.isPresent()) {
            recipe = recipeOptional.get();
        }
        User user = new User();
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        RecipeRate recipeRate = new RecipeRate();
        recipeRate.setUser(user);
        recipeRate.setRecipe(recipe);
        recipeRate.setRate(rate);

        Double currRate = 0.0;
        int currRateCount = 0;
        for (RecipeRate r : recipeReteRepository.findAll()) {
            if (r.getRecipe().getId().equals(recipeId)) {
                currRate += r.getRate();
                currRateCount++;
            }
        }
        Double newRate = (currRate + rate) / (currRateCount + 1);
        recipe.setRate(newRate);
        return recipeReteRepository.save(recipeRate).getId();
    }

}
