package com.example.demo.controller;

import com.example.demo.dto.RateRecipeDto;
import com.example.demo.service.RecipeRateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reciperate")
public class RecipeRateController {
    private final RecipeRateService recipeRateService;

    public RecipeRateController(RecipeRateService recipeRateService) {
        this.recipeRateService = recipeRateService;
    }

    @PostMapping("/addrate")
    public Long addRecipeToFavourites(@RequestBody RateRecipeDto recipeDto) {
        return recipeRateService.addRecipeRate(recipeDto.getRecipeId(), recipeDto.getUserId(), recipeDto.getRate());
    }
}
