package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.models.*;
import com.socialfitness.socialfitness.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImplementation implements CommentService{

    @Autowired
    private UserService userService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private MealPlanRepository mealPlanRepository;
    @Autowired
    private MealPlanService mealPlanService;
    @Autowired
    private WorkOutStatusService workOutStatusService;
    @Autowired
    private WorkOutStatusRepository workOutStatusRepository;
    @Autowired
    private WorkOutGoalRepository workOutGoalRepository;
    @Autowired
    private WorkOutGoalService workOutGoalService;

    @Override
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception {
        User user=userService.findUserById(userId);

        Post post=postService.findPostById(postId);

        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedComment = commentRepository.save(comment);

        post.getComments().add(savedComment);

        postRepository.save(post);

        return savedComment;
    }

    @Override
    public Comment createStatusComment(Comment comment, Integer postId, Integer userId) throws Exception {
        User user=userService.findUserById(userId);

        WorkOutStatus workOutStatus = workOutStatusService.findWorkOutStatusPostById(postId);

        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedStatusPostComment = commentRepository.save(comment);

        workOutStatus.getComments().add(savedStatusPostComment);

        workOutStatusRepository.save(workOutStatus);

        return savedStatusPostComment;
    }

    @Override
    public Comment createMealComment(Comment comment, Integer postId, Integer userId) throws Exception {
        User user=userService.findUserById(userId);

        MealPlan mealPlan =  mealPlanService.findMealPlanPostById(postId);

        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedMealComment = commentRepository.save(comment);

        mealPlan.getComments().add(savedMealComment);

        mealPlanRepository.save(mealPlan);

        return savedMealComment;
    }

    @Override
    public Comment createGoalComment(Comment comment, Integer postId, Integer userId) throws Exception {
        User user=userService.findUserById(userId);

        WorkOutGoal workOutGoal = workOutGoalService.findWorkOutGoalPostById(postId);

        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedGoalComment = commentRepository.save(comment);

        workOutGoal.getComments().add(savedGoalComment);

        workOutGoalRepository.save(workOutGoal);

        return savedGoalComment;
    }

    @Override
    public Comment findCommentById(Integer commentId) throws Exception {
        Optional<Comment> opt = commentRepository.findById(commentId);

        if(opt.isEmpty()){
            throw new Exception("comment not exist.");

        }
        return opt.get();
    }

    @Override
    public Comment likeComment(Integer commentId, Integer userId) throws Exception {
        Comment comment = findCommentById(commentId);
        User user = userService.findUserById(userId);

        if(!comment.getLiked().contains(user)){
            comment.getLiked().add(user);
        }else{
            comment.getLiked().remove(user);
        }
        return commentRepository.save(comment);
    }
}
