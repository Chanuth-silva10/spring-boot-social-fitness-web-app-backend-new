package com.socialfitness.socialfitness.controller;

import com.socialfitness.socialfitness.exceptions.UserException;
import com.socialfitness.socialfitness.models.Post;
import com.socialfitness.socialfitness.models.User;
import com.socialfitness.socialfitness.response.ApiResponse;
import com.socialfitness.socialfitness.service.PostService;
import com.socialfitness.socialfitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @PostMapping("/api/posts")
    public ResponseEntity<Post> createPost(
            @RequestHeader("Authorization") String jwt,
            @RequestBody Post post) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);

        Post createdPost = postService.createNewPost(post,reqUser.getId());


        return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId, @RequestHeader("Authorization") String jwt) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);
        String message = postService.deletePost(postId,reqUser.getId());
        ApiResponse res = new ApiResponse(message,true);


        return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
    }

    @GetMapping("/api/posts/{postId}")
    public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws Exception{

        Post post=postService.findPostById(postId);

        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }

    @GetMapping("api/posts/user/{userId}")
    public ResponseEntity<List<Post>> findUsersPost(@PathVariable Integer userId) throws Exception{

        List<Post> posts=postService.findPostByUserId(userId);

        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }

    @GetMapping("/api/posts")
    public ResponseEntity<List<Post>> findAllPost() throws Exception{

        List<Post> posts=postService.findAllPost();

        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }


    @PutMapping("/api/posts/like/{postId}")
    public ResponseEntity<Post> likePostHandler(@PathVariable Integer postId,@RequestHeader("Authorization") String jwt) throws Exception{

        User reqUser = userService.findUserByJwt(jwt);

        Post post=postService.likePost(postId,reqUser.getId());

        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/posts/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer postId,@RequestBody Post post,@RequestHeader("Authorization") String jwt) throws Exception{

        User reqUser = userService.findUserByJwt(jwt);

        Post updatedPost=postService.updatePost(postId, post,reqUser.getId());

        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }

}
