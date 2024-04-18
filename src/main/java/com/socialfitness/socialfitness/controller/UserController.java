package com.socialfitness.socialfitness.controller;

import com.socialfitness.socialfitness.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers(){

        List<User> users = new ArrayList<>();

        User user1 = new User(1,"Chanuth","Maduka","chanuth@gmail.com","12345");
        User user2 = new User(2,"Maduka","Kumara","chanuth@gmail.com","123335");
        users.add(user1);
        users.add(user2);

        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer id){

        List<User> users = new ArrayList<>();

        User user1 = new User(1,"Chanuth","Maduka","chanuth@gmail.com","12345");User user2 = new User(2,"Maduka","Kumara","chanuth@gmail.com","123335");
        user1.setId(id);

        return user1;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        newUser.setId(user.getId());

        return newUser;
    }
    @PutMapping("/users")
    public User updateUser(@RequestBody User user){

        User user1 = new User(1,"Chanuth","Maduka","chanuth@gmail.com","12345");

        if(user.getFirstName()!=null){
            user1.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null){
            user1.setLastName(user.getLastName());
        }
        if(user.getEmail()!=null){
            user1.setEmail(user.getEmail());
        }

        return user1;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId){

        return "user deleted ok" + userId;
    }

}
