package com.socialfitness.socialfitness.controller;

import com.socialfitness.socialfitness.models.Post;
import com.socialfitness.socialfitness.models.WorkOutStatus;
import com.socialfitness.socialfitness.models.User;
import com.socialfitness.socialfitness.response.ApiResponse;
import com.socialfitness.socialfitness.service.UserService;
import com.socialfitness.socialfitness.service.WorkOutStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkOutStatusController {

    @Autowired
    WorkOutStatusService postService;
    @Autowired
    UserService userService;

    @PostMapping("/api/status")
    public ResponseEntity<WorkOutStatus> createPost(
            @RequestHeader("Authorization") String jwt,
            @RequestBody WorkOutStatus post) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);

        WorkOutStatus createdPost = postService.createNewWorkOutStatusPost(post,reqUser.getId());


        return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/status/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId, @RequestHeader("Authorization") String jwt) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);
        String message = postService.deleteWorkOutStatusPost(postId,reqUser.getId());
        ApiResponse res = new ApiResponse(message,true);


        return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
    }

    @GetMapping("/api/status/{postId}")
    public ResponseEntity<WorkOutStatus> findPostByIdHandler(@PathVariable Integer postId) throws Exception{

        WorkOutStatus post=postService.findWorkOutStatusPostById(postId);

        return new ResponseEntity<WorkOutStatus>(post,HttpStatus.ACCEPTED);
    }

    @GetMapping("api/status/user/{userId}")
    public ResponseEntity<List<WorkOutStatus>> findUsersPost(@PathVariable Integer userId) throws Exception{

        List<WorkOutStatus> status=postService.findWorkOutStatusPostByUserId(userId);

        return new ResponseEntity<List<WorkOutStatus>>(status,HttpStatus.OK);
    }

    @GetMapping("/api/status")
    public ResponseEntity<List<WorkOutStatus>> findAllPost() throws Exception{

        List<WorkOutStatus> status=postService.findAllWorkOutStatusPost();

        return new ResponseEntity<List<WorkOutStatus>>(status,HttpStatus.OK);
    }

    @PutMapping("/api/status/like/{postId}")
    public ResponseEntity<WorkOutStatus> likePostHandler(@PathVariable Integer postId,@RequestHeader("Authorization") String jwt) throws Exception{

        User reqUser = userService.findUserByJwt(jwt);

        WorkOutStatus post=postService.likeWorkOutStatusPost(postId,reqUser.getId());

        return new ResponseEntity<WorkOutStatus>(post,HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/status/{postId}")
    public WorkOutStatus updateStatusPost(@PathVariable Integer postId, @RequestBody WorkOutStatus post, @RequestHeader("Authorization") String jwt) throws Exception{

        User reqUser = userService.findUserByJwt(jwt);

        WorkOutStatus updatedStatusPost=postService.updateStatusPost(postId, post,reqUser.getId());

        return updatedStatusPost;
    }
}
