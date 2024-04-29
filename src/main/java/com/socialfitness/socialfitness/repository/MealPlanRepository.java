package com.socialfitness.socialfitness.repository;

import com.socialfitness.socialfitness.models.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MealPlanRepository extends JpaRepository<MealPlan,Integer> {

    @Query("select p from MealPlan p where p.user.id =:userId")
    List<MealPlan> findMealPlanPostByUserId(Integer userId);

}
