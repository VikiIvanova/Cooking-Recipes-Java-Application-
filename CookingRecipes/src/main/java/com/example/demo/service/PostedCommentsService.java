package com.example.demo.service;

import com.example.demo.model.PostedComments;
import com.example.demo.model.Recipe;
import com.example.demo.model.User;
import com.example.demo.repository.PostedCommentsRepository;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostedCommentsService {
    private final PostedCommentsRepository postedCommentsRepository;
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;


    public PostedCommentsService(PostedCommentsRepository postedCommentsRepository, RecipeRepository recipeRepository, UserRepository userRepository) {
        this.postedCommentsRepository = postedCommentsRepository;
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }

    public Long postComment(Long recipeId, Long userId, String comment) {
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
        PostedComments postedComment = new PostedComments();
        postedComment.setUser(user);
        postedComment.setRecipe(recipe);
        postedComment.setComment(comment);
        return postedCommentsRepository.save(postedComment).getId();
    }

    public List<String> getAllCommentsToRecipe(Long recipeId){
        List<String> comments = new ArrayList<>();
        for(PostedComments c : postedCommentsRepository.findAll()){
            if(c.getRecipe().getId().equals(recipeId)){
                comments.add(c.getComment());
            }
        }
        return comments;
    }
}
