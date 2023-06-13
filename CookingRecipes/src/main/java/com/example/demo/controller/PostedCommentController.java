package com.example.demo.controller;

import com.example.demo.dto.PostCommentDto;
import com.example.demo.service.PostedCommentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postedcomments")
public class PostedCommentController {
    private final PostedCommentsService postedCommentsService;

    public PostedCommentController(PostedCommentsService postedCommentsService) {
        this.postedCommentsService = postedCommentsService;
    }

    @PostMapping("/postcomment")
    public Long addRecipeToFavourites(@RequestBody PostCommentDto postCommentDto) {
        return postedCommentsService.postComment(postCommentDto.getRecipeId(), postCommentDto.getUserId(), postCommentDto.getComment());
    }

    @GetMapping("/allcomments/{recipeId}")
    public List<String> allPostedComments(@PathVariable Long recipeId) {
        return postedCommentsService.getAllCommentsToRecipe(recipeId);
    }

}
