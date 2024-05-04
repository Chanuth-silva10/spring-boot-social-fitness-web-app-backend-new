package com.socialfitness.socialfitness.controller;

import com.socialfitness.socialfitness.models.MealPlan;
import com.socialfitness.socialfitness.models.User;
import com.socialfitness.socialfitness.response.ApiResponse;
import com.socialfitness.socialfitness.service.MealPlanService;
import com.socialfitness.socialfitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealPlanController {

    @Autowired
    MealPlanService postService;
    @Autowired
    UserService userService;

    @PostMapping("/api/meals")
    public ResponseEntity<MealPlan> createMealPlanPost(
            @RequestHeader("Authorization") String jwt,
            @RequestBody MealPlan post) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);

        MealPlan createdPost = postService.createNewMealPlanPost(post,reqUser.getId());


        return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/meals/{postId}")
    public ResponseEntity<ApiResponse> deleteMealPlanPost(@PathVariable Integer postId, @RequestHeader("Authorization") String jwt) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);
        String message = postService.deleteMealPlanPost(postId,reqUser.getId());
        ApiResponse res = new ApiResponse(message,true);


        return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
    }

    @GetMapping("/api/meals/{postId}")
    public ResponseEntity<MealPlan> findMealPlanPostByIdHandler(@PathVariable Integer postId) throws Exception{

        MealPlan post=postService.findMealPlanPostById(postId);

        return new ResponseEntity<MealPlan>(post,HttpStatus.ACCEPTED);
    }

    @GetMapping("api/meals/user/{userId}")
    public ResponseEntity<List<MealPlan>> findUsersMealPlanPost(@PathVariable Integer userId) throws Exception{

        List<MealPlan> posts=postService.findMealPlanPostByUserId(userId);

        return new ResponseEntity<List<MealPlan>>(posts,HttpStatus.OK);
    }

    @GetMapping("/api/meals")
    public ResponseEntity<List<MealPlan>> findAllMealPlanPost() throws Exception{

        List<MealPlan> posts=postService.findAllMealPlanPost();

        return new ResponseEntity<List<MealPlan>>(posts,HttpStatus.OK);
    }

    @PutMapping("/api/meals/like/{postId}")
    public ResponseEntity<MealPlan> likeMealPlanPostHandler(@PathVariable Integer postId,@RequestHeader("Authorization") String jwt) throws Exception{

        User reqUser = userService.findUserByJwt(jwt);

        MealPlan post=postService.likeMealPlanPost(postId,reqUser.getId());

        return new ResponseEntity<MealPlan>(post,HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/meals/{postId}")
    public ResponseEntity<MealPlan> updateMealPlanPost(@PathVariable Integer postId, @RequestBody MealPlan post, @RequestHeader("Authorization") String jwt) throws Exception{

        User reqUser = userService.findUserByJwt(jwt);

        MealPlan updatedMealPost=postService.updateMealPlanPost(postId, post,reqUser.getId());

        return new ResponseEntity<MealPlan>(updatedMealPost,HttpStatus.ACCEPTED);
    }
}
