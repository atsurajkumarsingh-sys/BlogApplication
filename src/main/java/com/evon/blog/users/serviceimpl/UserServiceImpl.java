package com.evon.blog.users.serviceimpl;

import com.evon.blog.exception.DuplicateRecordException;
import com.evon.blog.exception.ResourceNotFoundException;
import com.evon.blog.users.entity.User;
import com.evon.blog.users.repository.UserRepository;
import com.evon.blog.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateRecordException("Record already exist with this email " + user.getEmail());
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        if(userRepository.findById(userId).isEmpty()) {
            throw new ResourceNotFoundException("Record not found");
        }
        return userRepository.findById(userId);
    }

    @Override
    public void deleteUser(Long userId) {
        if(userRepository.findById(userId).isEmpty()) {
            throw new ResourceNotFoundException("Record not found");
        }
        userRepository.deleteById(userId);
    }
}