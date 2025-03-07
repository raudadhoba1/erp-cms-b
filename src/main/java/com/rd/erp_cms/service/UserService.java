package com.rd.erp_cms.service;

import com.rd.erp_cms.model.User;
import com.rd.erp_cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public boolean deleteUser(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        if (user.isPresent()) {
            userRepository.deleteByUserId(userId);  // Delete user by userId
            return true;
        }
        return false;  // If user doesn't exist
    }

}
