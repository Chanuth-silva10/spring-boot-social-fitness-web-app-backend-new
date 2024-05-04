package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.models.MealPlan;
import com.socialfitness.socialfitness.models.Post;

import java.util.List;

public interface MealPlanService {

    MealPlan createNewMealPlanPost(MealPlan post, Integer userId)throws Exception;
    String deleteMealPlanPost(Integer portId,Integer userId) throws Exception;
    List<MealPlan> findMealPlanPostByUserId(Integer userId) throws Exception;
    MealPlan findMealPlanPostById(Integer postId) throws Exception;
    List<MealPlan> findAllMealPlanPost();
    MealPlan likeMealPlanPost(Integer postId,Integer userId) throws Exception;
    MealPlan updateMealPlanPost(Integer postId, MealPlan post, Integer userId) throws Exception;
}
