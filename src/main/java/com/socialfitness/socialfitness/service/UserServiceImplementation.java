package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.config.JwtProvider;
import com.socialfitness.socialfitness.models.User;
import com.socialfitness.socialfitness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public User findUserById(Integer userld) throws Exception {
        Optional<User> user = userRepository.findById(userld);

        if (user.isPresent()) {
            return user.get();
        }

        throw new Exception("user does not exit" + userld);
    }

    @Override
    public User findUserByEmail(String email) {

        User user = userRepository.findByEmail(email);

        return user;
    }

    @Override
    public User followUser(Integer reqUserId, Integer userld2) throws Exception {

        User reqUser = findUserById(reqUserId);

        User user2 = findUserById(userld2);

        user2.getFollowers().add(reqUser.getId());
        reqUser.getFollowers().add(user2.getId());

        userRepository.save(reqUser);
        userRepository.save(user2);

        return reqUser;
    }

    @Override
    public User updateUser(User user, Integer userId) throws Exception {

        Optional<User> user1 = userRepository.findById(userId);

        if (user1.isEmpty()) {
            throw new Exception("User not exit with id" + userId);
        }

        User oldUser = user1.get();

        if (user.getFirstName() != null) {
            oldUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            oldUser.setLastName(user.getLastName());
        }
        if (user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }
        if (user.getGender() != null) {
            oldUser.setGender(user.getGender());
        }

        User updatedUser = userRepository.save(oldUser);

        return updatedUser;
    }

    @Override
    public List<User> searchUser(String query) {
        return userRepository.searchUser(query);
    }

    @Override
    public User findUserByJwt(String jwt) {

        String email = JwtProvider.getEmailFromJwtToken(jwt);

        User user = userRepository.findByEmail(email);
        return user;
    }
}
