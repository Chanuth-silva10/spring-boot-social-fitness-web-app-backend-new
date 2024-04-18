package com.socialfitness.socialfitness.controller;

import com.socialfitness.socialfitness.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers(){

        List<User> users = new ArrayList<>();

        User user1 = new User("Chanuth","Maduka","chanuth@gmail.com","12345");

        users.add(user1);

        return users;
    }
}
