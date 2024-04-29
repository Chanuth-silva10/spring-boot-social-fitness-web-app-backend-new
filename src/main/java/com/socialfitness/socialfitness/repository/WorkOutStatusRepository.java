package com.socialfitness.socialfitness.repository;


import com.socialfitness.socialfitness.models.WorkOutStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkOutStatusRepository extends JpaRepository<WorkOutStatus,Integer> {
    @Query("select p from WorkOutStatus p where p.user.id =:userId")
    List<WorkOutStatus> findWorkOutStatusPostByUserId(Integer userId);
}
