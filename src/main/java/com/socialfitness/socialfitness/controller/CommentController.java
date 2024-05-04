package com.socialfitness.socialfitness.controller;

import com.socialfitness.socialfitness.models.Comment;
import com.socialfitness.socialfitness.models.User;
import com.socialfitness.socialfitness.service.CommentService;
import com.socialfitness.socialfitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @PostMapping("/api/comments/post/{postId}")
    public Comment createPostComment(@RequestBody Comment comment,
                                 @RequestHeader("Authorization") String jwt,
                                 @PathVariable("postId") Integer postId) throws Exception {
        User user = userService.findUserByJwt(jwt);

        Comment createdComment = commentService.createComment(comment,postId,user.getId());

        return createdComment;


    }

    @PutMapping("/api/comments/like/{commentId}")
    public Comment likeComment(@RequestHeader("Authorization") String jwt,
                                 @PathVariable("postId") Integer commentId) throws Exception {
        User user = userService.findUserByJwt(jwt);

        Comment likedComment = commentService.likeComment(commentId,user.getId());

        return likedComment;

    }

    @PostMapping("/api/comments/status/{postId}")
    public Comment createStatusComment(@RequestBody Comment comment,
                                 @RequestHeader("Authorization") String jwt,
                                 @PathVariable("postId") Integer postId) throws Exception {
        User user = userService.findUserByJwt(jwt);

        Comment createdStatusComment = commentService.createStatusComment(comment,postId,user.getId());

        return createdStatusComment;


    }

    @PostMapping("/api/comments/meal/{postId}")
    public Comment createMealComment(@RequestBody Comment comment,
                                 @RequestHeader("Authorization") String jwt,
                                 @PathVariable("postId") Integer postId) throws Exception {
        User user = userService.findUserByJwt(jwt);

        Comment createdMealComment = commentService.createMealComment(comment,postId,user.getId());

        return createdMealComment;


    }

    @PostMapping("/api/comments/goal/{postId}")
    public Comment createGoalComment(@RequestBody Comment comment,
                                 @RequestHeader("Authorization") String jwt,
                                 @PathVariable("postId") Integer postId) throws Exception {
        User user = userService.findUserByJwt(jwt);

        Comment createdGoalComment = commentService.createGoalComment(comment,postId,user.getId());

        return createdGoalComment;


    }

}
