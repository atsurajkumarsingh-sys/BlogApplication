package com.evon.blog.users.service;

import com.evon.blog.users.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    User updateUser(Long id, User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long userId);

    void deleteUser(Long userId);
}