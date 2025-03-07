package com.rd.erp_cms.repository;

import com.rd.erp_cms.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByUserId(String userId);
    // Custom queries (if needed) can be added here
}
