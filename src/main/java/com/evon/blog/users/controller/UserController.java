package com.evon.blog.users.controller;

import com.evon.blog.users.entity.User;
import com.evon.blog.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/api/updateUser")
    public User updateUser(@RequestParam Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @GetMapping("/api/getUserById")
    public Optional<User> getUserById(@RequestParam Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/api/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/api/deleteUser")
    public void deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/api/getUserByName")
    public Optional<User> getUserByName(@RequestParam String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/api/getUserByEmail")
    public Optional<User> getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }
}