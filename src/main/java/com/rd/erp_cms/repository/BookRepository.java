package com.rd.erp_cms.repository;



import com.rd.erp_cms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
