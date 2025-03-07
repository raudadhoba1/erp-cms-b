package com.rd.erp_cms.service;

import com.rd.erp_cms.model.User;
import com.rd.erp_cms.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    // Authenticate user by either userId or email
    public User authenticate(String userIdOrEmail, String password) {
        // Try to find the user by email first
        Optional<User> user = authenticationRepository.findByEmail(userIdOrEmail);

        // If not found by email, check by userId
        if (user.isEmpty()) {
            user = authenticationRepository.findByUserId(userIdOrEmail);
        }

        // If user is found, check if passwords match
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();  // Return the user if authentication is successful
        }

        // If no match or password doesn't match, return null
        return null;
    }
}
