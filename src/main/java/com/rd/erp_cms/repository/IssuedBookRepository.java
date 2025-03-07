package com.rd.erp_cms.repository;

import com.rd.erp_cms.model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBookRepository extends JpaRepository<IssuedBook, String> {
}
