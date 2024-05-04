package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.models.Comment;

public interface CommentService {

    public Comment createComment(
            Comment comment,
            Integer postId,
            Integer userId
    ) throws Exception;
    public Comment createStatusComment(
            Comment comment,
            Integer postId,
            Integer userId
    ) throws Exception;
    public Comment createMealComment(
            Comment comment,
            Integer postId,
            Integer userId
    ) throws Exception;
    public Comment createGoalComment(
            Comment comment,
            Integer postId,
            Integer userId
    ) throws Exception;
    public Comment findCommentById(Integer commentId) throws Exception;
    public Comment likeComment(Integer commentId, Integer userId) throws Exception;
}
