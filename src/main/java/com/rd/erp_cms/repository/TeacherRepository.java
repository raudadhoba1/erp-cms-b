package com.rd.erp_cms.repository;

import com.rd.erp_cms.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String email);// You can add custom methods if needed
    Optional<Teacher> findByUserId(String userId); // Add this method>

    void deleteByUserId(String userId);

    boolean existsByUserId(String userId);

    long count();
}
