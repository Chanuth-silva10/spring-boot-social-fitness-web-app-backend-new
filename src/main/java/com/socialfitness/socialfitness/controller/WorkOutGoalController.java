package com.socialfitness.socialfitness.controller;

import com.socialfitness.socialfitness.models.WorkOutGoal;
import com.socialfitness.socialfitness.models.User;
import com.socialfitness.socialfitness.response.ApiResponse;
import com.socialfitness.socialfitness.service.UserService;
import com.socialfitness.socialfitness.service.WorkOutGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkOutGoalController {

    @Autowired
    WorkOutGoalService postService;
    @Autowired
    UserService userService;

    @PostMapping("/api/goal")
    public ResponseEntity<WorkOutGoal> createPost(
            @RequestHeader("Authorization") String jwt,
            @RequestBody WorkOutGoal post) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);

        WorkOutGoal createdPost = postService.createNewWorkOutGoalPost(post,reqUser.getId());

        return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/goals/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId, @RequestHeader("Authorization") String jwt) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);
        String message = postService.deleteWorkOutGoalPost(postId,reqUser.getId());
        ApiResponse res = new ApiResponse(message,true);


        return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
    }

    @GetMapping("/api/goals/{postId}")
    public ResponseEntity<WorkOutGoal> findPostByIdHandler(@PathVariable Integer postId) throws Exception{

        WorkOutGoal post=postService.findWorkOutGoalPostById(postId);

        return new ResponseEntity<WorkOutGoal>(post,HttpStatus.ACCEPTED);
    }

    @GetMapping("api/goals/user/{userId}")
    public ResponseEntity<List<WorkOutGoal>> findUsersPost(@PathVariable Integer userId) throws Exception{

        List<WorkOutGoal> posts=postService.findWorkOutGoalPostByUserId(userId);

        return new ResponseEntity<List<WorkOutGoal>>(posts,HttpStatus.OK);
    }

    @GetMapping("/api/goals")
    public ResponseEntity<List<WorkOutGoal>> findAllPost() throws Exception{

        List<WorkOutGoal> posts=postService.findAllWorkOutGoalPost();

        return new ResponseEntity<List<WorkOutGoal>>(posts,HttpStatus.OK);
    }

    @PutMapping("/api/goals/like/{postId}")
    public ResponseEntity<WorkOutGoal> likePostHandler(@PathVariable Integer postId,@RequestHeader("Authorization") String jwt) throws Exception{

        User reqUser = userService.findUserByJwt(jwt);

        WorkOutGoal post=postService.likeWorkOutGoalPost(postId,reqUser.getId());

        return new ResponseEntity<WorkOutGoal>(post,HttpStatus.ACCEPTED);
    }
}
