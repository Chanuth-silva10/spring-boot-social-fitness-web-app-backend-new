package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.models.Post;
import com.socialfitness.socialfitness.models.WorkOutStatus;

import java.util.List;

public interface WorkOutStatusService {

    WorkOutStatus createNewWorkOutStatusPost(WorkOutStatus post, Integer userId)throws Exception;
    String deleteWorkOutStatusPost(Integer portId,Integer userId) throws Exception;
    List<WorkOutStatus> findWorkOutStatusPostByUserId(Integer userId) throws Exception;
    WorkOutStatus findWorkOutStatusPostById(Integer postId) throws Exception;
    List<WorkOutStatus> findAllWorkOutStatusPost();
    WorkOutStatus likeWorkOutStatusPost(Integer postId,Integer userId) throws Exception;
    WorkOutStatus updateStatusPost(Integer postId, WorkOutStatus post, Integer userId) throws Exception;
}
