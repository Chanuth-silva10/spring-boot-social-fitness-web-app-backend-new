package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.exceptions.UserException;
import com.socialfitness.socialfitness.models.User;

import java.util.List;

public interface UserService {

    public User registerUser(User user);

    public User findUserById(Integer userld) throws UserException;

    public User findUserByEmail (String email);

    public User followUser(Integer userld1, Integer userld2) throws UserException;

    public User updateUser(User user, Integer userId) throws UserException;

    public List<User> searchUser(String query);

    public User findUserByJwt(String jwt);


}
