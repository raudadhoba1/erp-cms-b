package com.rd.erp_cms.service;

import com.rd.erp_cms.model.IssuedBook;
import com.rd.erp_cms.repository.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssuedBookService {

    @Autowired
    private IssuedBookRepository issuedBookRepository;

    public List<IssuedBook> getAllIssuedBooks() {
        return issuedBookRepository.findAll();
    }

    public Optional<IssuedBook> getIssuedBookById(String bookId) {
        return issuedBookRepository.findById(bookId);
    }

    public IssuedBook issueBook(IssuedBook issuedBook) {
        return issuedBookRepository.save(issuedBook);
    }

    public void returnBook(String bookId) {
        issuedBookRepository.deleteById(bookId);
    }
}
