package com.rd.erp_cms.repository;

import com.rd.erp_cms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long>{

    void deleteByUserId(String userId);

    Optional<User> findByUserId(String userId);

    Optional<User> getUserByUserId(String userId);

    boolean existsByUserId(String userId);
}
