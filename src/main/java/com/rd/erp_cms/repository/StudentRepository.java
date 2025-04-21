package com.rd.erp_cms.repository;

import com.rd.erp_cms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByUserId(String userID);
    void deleteByUserId(String userId);
    boolean existsByUserId(String userID);

    long count();
}

