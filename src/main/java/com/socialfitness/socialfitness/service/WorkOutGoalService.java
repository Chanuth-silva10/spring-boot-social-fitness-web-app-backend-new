package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.models.WorkOutGoal;

import java.util.List;

public interface WorkOutGoalService {

    WorkOutGoal createNewWorkOutGoalPost(WorkOutGoal post, Integer userId)throws Exception;
    String deleteWorkOutGoalPost(Integer portId,Integer userId) throws Exception;
    List<WorkOutGoal> findWorkOutGoalPostByUserId(Integer userId) throws Exception;
    WorkOutGoal findWorkOutGoalPostById(Integer postId) throws Exception;
    List<WorkOutGoal> findAllWorkOutGoalPost();
    WorkOutGoal likeWorkOutGoalPost(Integer postId,Integer userId) throws Exception;
}
