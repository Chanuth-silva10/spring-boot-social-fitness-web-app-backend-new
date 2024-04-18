package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.models.Post;

import java.util.List;

public interface PostService {

    Post createNewPost(Post post,Integer userId)throws Exception;
    String deletePost(Integer portId,Integer userId) throws Exception;
    List<Post> findPostByUserId(Integer userId) throws Exception;
    Post findPostById(Integer postId) throws Exception;
    List<Post> findAllPost();
    Post savedPost(Integer postId,Integer userId) throws Exception;
    Post likePost(Integer postId,Integer userId) throws Exception;
}
