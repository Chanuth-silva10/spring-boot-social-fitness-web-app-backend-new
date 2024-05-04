package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.models.Post;
import com.socialfitness.socialfitness.models.User;
import com.socialfitness.socialfitness.models.WorkOutStatus;
import com.socialfitness.socialfitness.repository.WorkOutStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WorkOutStatusServiceImplementation implements WorkOutStatusService{

    @Autowired
    WorkOutStatusRepository postRepository;
    @Autowired
    UserService userService;

    @Override
    public WorkOutStatus createNewWorkOutStatusPost(WorkOutStatus post, Integer userId) throws Exception {

        User user = userService.findUserById(userId);
        WorkOutStatus newPost = new WorkOutStatus();
        newPost.setCaption(post.getCaption());
        newPost.setDistanceRun(post.getDistanceRun());
        newPost.setPushupsCompleted(post.getPushupsCompleted());
        newPost.setWeightLifted(post.getWeightLifted());
        newPost.setCreatedAt(LocalDateTime.now());
        newPost.setUser(user);


        return postRepository.save(newPost);
    }

    @Override
    public String deleteWorkOutStatusPost(Integer postId, Integer userId) throws Exception {
        WorkOutStatus post = findWorkOutStatusPostById(postId);
        User user = userService.findUserById(userId);

        if(post.getUser().getId()!=user.getId()){
            throw new Exception("You can not delete another users post.");
        }

        postRepository.delete(post);

        return "post deleted successfully";
    }

    @Override
    public List<WorkOutStatus> findWorkOutStatusPostByUserId(Integer userId) throws Exception {

        return postRepository.findWorkOutStatusPostByUserId(userId);
    }

    @Override
    public WorkOutStatus findWorkOutStatusPostById(Integer postId) throws Exception {
        Optional<WorkOutStatus> opt = postRepository.findById(postId);
        if(opt.isEmpty()){
            throw new Exception("post not found with id " + postId);
        }

        return opt.get();
    }


    @Override
    public List<WorkOutStatus> findAllWorkOutStatusPost() {
        return postRepository.findAll();
    }


    @Override
    public WorkOutStatus likeWorkOutStatusPost(Integer postId, Integer userId) throws Exception {
        WorkOutStatus post = findWorkOutStatusPostById(postId);
        User user = userService.findUserById(userId);

        if(post.getLiked().contains(user)){
            post.getLiked().remove(user);
        }else{
            post.getLiked().add(user);
        }


        return postRepository.save(post);
    }

    @Override
    public WorkOutStatus updateStatusPost(Integer postId, WorkOutStatus post, Integer userId) throws Exception {

        Optional<WorkOutStatus> post1 = postRepository.findById(postId);
        WorkOutStatus oldPost = post1.get();
        User user = userService.findUserById(userId);

        if (post1.isEmpty()) {
            throw new Exception("Post not exit with id" + postId);
        }

        if(oldPost.getUser().getId()!=user.getId()){
            throw new Exception("You can not update another users post.");
        }

        if (post.getCaption() != null) {
            oldPost.setCaption(post.getCaption());
        }

        if (post.getDistanceRun() != 0.0) {
            oldPost.setDistanceRun(post.getDistanceRun());
        }

        if (post.getPushupsCompleted() != 0) {
            oldPost.setPushupsCompleted(post.getPushupsCompleted());
        }

        if (post.getWeightLifted() != 0.0) {
            oldPost.setWeightLifted(post.getWeightLifted());
        }


        WorkOutStatus updatedPost = postRepository.save(oldPost);

        return updatedPost;
    }
}
