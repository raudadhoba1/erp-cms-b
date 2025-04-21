package com.rd.erp_cms.repository;

import com.rd.erp_cms.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
    // No need to define any custom methods for basic CRUD operations
}

