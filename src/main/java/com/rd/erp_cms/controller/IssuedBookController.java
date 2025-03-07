package com.rd.erp_cms.controller;

import com.rd.erp_cms.model.IssuedBook;
import com.rd.erp_cms.service.IssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/issued-books")
public class IssuedBookController {

    @Autowired
    private IssuedBookService issuedBookService;

    // Get all issued books
    @GetMapping
    public List<IssuedBook> getAllIssuedBooks() {
        return issuedBookService.getAllIssuedBooks();
    }

    // Get issued book by ID
    @GetMapping("/{bookId}")
    public ResponseEntity<IssuedBook> getIssuedBook(@PathVariable String bookId) {
        Optional<IssuedBook> issuedBook = issuedBookService.getIssuedBookById(bookId);
        return issuedBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Issue a new book
    @PostMapping("/addIssuedBook")
    public ResponseEntity<IssuedBook> issueBook(@RequestBody IssuedBook issuedBook) {
        IssuedBook newIssuedBook = issuedBookService.issueBook(issuedBook);
        return ResponseEntity.ok(newIssuedBook);
    }

    // Return a book (delete the record)
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> returnBook(@PathVariable String bookId) {
        issuedBookService.returnBook(bookId);
        return ResponseEntity.noContent().build();
    }
}
