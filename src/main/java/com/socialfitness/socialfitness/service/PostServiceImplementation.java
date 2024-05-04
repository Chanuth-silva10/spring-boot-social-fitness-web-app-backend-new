package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.exceptions.UserException;
import com.socialfitness.socialfitness.models.Post;
import com.socialfitness.socialfitness.models.User;
import com.socialfitness.socialfitness.repository.PostRepository;
import com.socialfitness.socialfitness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImplementation implements PostService{

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Override
    public Post createNewPost(Post post, Integer userId) throws Exception {

        User user = userService.findUserById(userId);
        Post newPost = new Post();
        newPost.setCaption(post.getCaption());
        newPost.setImage(post.getImage());
        newPost.setCreatedAt(LocalDateTime.now());
        newPost.setVideo(post.getVideo());
        newPost.setUser(user);


        return postRepository.save(newPost);
    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws Exception {
        Post post = findPostById(postId);
        User user = userService.findUserById(userId);

        if(post.getUser().getId()!=user.getId()){
            throw new Exception("You can not delete another users post.");
        }

        postRepository.delete(post);

        return "post deleted successfully";
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) throws Exception {

        return postRepository.findPostByUserId(userId);
    }

    @Override
    public Post findPostById(Integer postId) throws Exception {
        Optional<Post> opt = postRepository.findById(postId);
        if(opt.isEmpty()){
            throw new Exception("post not found with id " + postId);
        }
        return opt.get();
    }

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post likePost(Integer postId, Integer userId) throws Exception {
        Post post = findPostById(postId);
        User user = userService.findUserById(userId);

        if(post.getLiked().contains(user)){
            post.getLiked().remove(user);
        }else{
            post.getLiked().add(user);
        }


        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Integer postId, Post post, Integer userId) throws Exception {

        Optional<Post> post1 = postRepository.findById(postId);
        Post oldPost = post1.get();
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

        if (post.getImage() != null) {
            oldPost.setImage(post.getImage());
        }

        if (post.getVideo() != null) {
            oldPost.setVideo(post.getVideo());
        }

        Post updatedPost = postRepository.save(oldPost);

        return updatedPost;
    }
}