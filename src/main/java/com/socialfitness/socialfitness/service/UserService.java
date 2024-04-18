package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.models.User;

import java.util.List;

public interface UserService {

    public User registerUser(User user);

    public User findUserById(Integer userld) throws Exception;

    public User findUserByEmail (String email);

    public User followUser(Integer userld1, Integer userld2) throws Exception;

    public User updateUser(User user, Integer userId) throws Exception;

    public List<User> searchUser(String query);


}
