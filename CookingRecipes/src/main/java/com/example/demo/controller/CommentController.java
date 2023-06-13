package com.example.demo.controller;

import com.example.demo.dto.CommentDto;
import com.example.demo.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postedcomments")
public class CommentController {
    private final CommentService postedCommentsService;

    public CommentController(CommentService postedCommentsService) {
        this.postedCommentsService = postedCommentsService;
    }

    @PostMapping("/comment")
    public Long addCommentToRecipe(@RequestBody CommentDto postCommentDto) {
        return postedCommentsService.postComment(postCommentDto.getRecipeId(),
                postCommentDto.getUserId(), postCommentDto.getComment());
    }

    @GetMapping("/allcomments/{recipeId}")
    public List<String> allComments(@PathVariable Long recipeId) {
        return postedCommentsService.getAllCommentsToRecipe(recipeId);
    }

}
