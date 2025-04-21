package com.rd.erp_cms.repository;

import com.rd.erp_cms.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibrarianRepository  extends JpaRepository<Librarian,Long> {
    Optional<Librarian> findByUserId(String userId);
    void deleteByUserId(String userId);
    boolean existsByUserId(String userId);
}
