package com.socialfitness.socialfitness.repository;

import com.socialfitness.socialfitness.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

}
