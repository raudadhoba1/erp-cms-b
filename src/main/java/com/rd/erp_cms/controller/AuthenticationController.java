package com.rd.erp_cms.controller;

import com.rd.erp_cms.dto.LoginDTO;
import com.rd.erp_cms.model.User;
import com.rd.erp_cms.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        String userIdOrEmail = loginDTO.getUserIdOrEmail();
        String password = loginDTO.getPassword();

        // Authenticate the user
        User authenticatedUser = authenticationService.authenticate(userIdOrEmail, password);

        if (authenticatedUser != null) {
            // Return success with user data (you can choose to hide sensitive information)
            return ResponseEntity.ok(authenticatedUser);
        } else {
            // Return an error if authentication fails
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
