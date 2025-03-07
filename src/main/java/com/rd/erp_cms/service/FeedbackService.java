package com.rd.erp_cms.service;

import com.rd.erp_cms.model.Feedback;
import com.rd.erp_cms.model.Feedback.UserRole;
import com.rd.erp_cms.repository.FeedbackRepository;
import com.rd.erp_cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UserRepository userRepository;

    public Feedback createFeedback(Feedback feedback) {
        // Here, you can check if the user exists based on the userId and their role
        if (userRepository.existsByUserId(feedback.getUserId())) {
            // Check if the user is valid based on the role
            if (isValidUserForRole(feedback.getUserId(), feedback.getRole())) {
                return feedbackRepository.save(feedback);
            } else {
                throw new RuntimeException("User is not valid for this role");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    private boolean isValidUserForRole(String userId, UserRole role) {
        // Implement role validation logic based on userId and role.
        // For instance, check if the userId belongs to the appropriate role (e.g., student, teacher, librarian).
        // You could call a repository method or perform your own logic here.
        // For simplicity, assuming it's valid:
        return true;
    }

    public Iterable<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));
    }

    public List<Feedback> getFeedbackByUserId(String userId) {
        return feedbackRepository.findByUserId(userId);
    }
}
