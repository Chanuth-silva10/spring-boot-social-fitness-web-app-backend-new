package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.models.MealPlan;
import com.socialfitness.socialfitness.models.Post;
import com.socialfitness.socialfitness.models.User;
import com.socialfitness.socialfitness.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MealPlanServiceImplementation implements MealPlanService{

    @Autowired
    MealPlanRepository postRepository;
    @Autowired
    UserService userService;

    @Override
    public MealPlan createNewMealPlanPost(MealPlan post, Integer userId) throws Exception {

        User user = userService.findUserById(userId);
        MealPlan newPost = new MealPlan();
        newPost.setCaption(post.getCaption());
        newPost.setDietaryPreferences(post.getDietaryPreferences());
        newPost.setRecipe(post.getRecipe());
        newPost.setImage(post.getImage());
        newPost.setCreatedAt(LocalDateTime.now());
        newPost.setUser(user);


        return postRepository.save(newPost);
    }

    @Override
    public String deleteMealPlanPost(Integer postId, Integer userId) throws Exception {
        MealPlan post = findMealPlanPostById(postId);
        User user = userService.findUserById(userId);

        if(post.getUser().getId()!=user.getId()){
            throw new Exception("You can not delete another users post.");
        }

        postRepository.delete(post);

        return "post deleted successfully";
    }

    @Override
    public List<MealPlan> findMealPlanPostByUserId(Integer userId) throws Exception {

        return postRepository.findMealPlanPostByUserId(userId);
    }

    @Override
    public MealPlan findMealPlanPostById(Integer postId) throws Exception {
        Optional<MealPlan> opt = postRepository.findById(postId);
        if(opt.isEmpty()){
            throw new Exception("post not found with id " + postId);
        }
        return opt.get();
    }

    @Override
    public List<MealPlan> findAllMealPlanPost() {
        return postRepository.findAll();
    }


    @Override
    public MealPlan likeMealPlanPost(Integer postId, Integer userId) throws Exception {
        MealPlan post = findMealPlanPostById(postId);
        User user = userService.findUserById(userId);

        if(post.getLiked().contains(user)){
            post.getLiked().remove(user);
        }else{
            post.getLiked().add(user);
        }


        return postRepository.save(post);
    }
    @Override
    public MealPlan updateMealPlanPost(Integer postId, MealPlan post, Integer userId) throws Exception {

        Optional<MealPlan> post1 = postRepository.findById(postId);
        MealPlan oldPost = post1.get();
        User user = userService.findUserById(userId);

        if (post1.isEmpty()) {
            throw new Exception("Post not exit with id" + postId);
        }

        if(oldPost.getUser().getId()!=user.getId()){
            throw new Exception("You can not update another users post.");
        }

        if (post.getDietaryPreferences() != null) {
            oldPost.setDietaryPreferences(post.getDietaryPreferences());
        }

        if (post.getRecipe() != null) {
            oldPost.setRecipe(post.getRecipe());
        }

        if (post.getCaption() != null) {
            oldPost.setCaption(post.getCaption());
        }

        if (post.getImage() != null) {
            oldPost.setImage(post.getImage());
        }


        MealPlan updatedPost = postRepository.save(oldPost);

        return updatedPost;
    }
}
