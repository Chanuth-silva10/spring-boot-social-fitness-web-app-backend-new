package com.socialfitness.socialfitness.repository;

import com.socialfitness.socialfitness.models.WorkOutGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkOutGoalRepository extends JpaRepository<WorkOutGoal,Integer> {

    @Query("select p from WorkOutGoal p where p.user.id =:userId")
    List<WorkOutGoal> findWorkOutGoalPostByUserId(Integer userId);
}
