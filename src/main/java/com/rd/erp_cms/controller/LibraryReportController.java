package com.rd.erp_cms.controller;


import com.rd.erp_cms.model.Book;
import com.rd.erp_cms.model.IssuedBook;
import com.rd.erp_cms.service.BookService;
import com.rd.erp_cms.service.IssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryReportController {

    @Autowired
    private BookService bookService;

    @Autowired
    private IssuedBookService issuedBookService;

    // Endpoint to get combined library report
    @GetMapping("/library-reports")
    public LibraryReport getLibraryReport() {
        // Fetching books and issued books from the services
        List<Book> books = bookService.getAllBooks();
        List<IssuedBook> issuedBooks = issuedBookService.getAllIssuedBooks();

        // Calculate total number of books, issued books, and overdue books
        int totalBooks = books.size();
        int totalIssuedBooks = issuedBooks.size();
        int overdueBooks = (int) issuedBooks.stream()
                .filter(book -> book.getReturnDate().before(new Date()))
                .count();

        // Return the combined report as a LibraryReport object
        return new LibraryReport(totalBooks, totalIssuedBooks, overdueBooks, books, issuedBooks);
    }

    // DTO to represent the library report
    public static class LibraryReport {
        private int totalBooks;
        private int totalIssuedBooks;
        private int overdueBooks;
        private List<Book> books;
        private List<IssuedBook> issuedBooks;

        public LibraryReport(int totalBooks, int totalIssuedBooks, int overdueBooks, List<Book> books, List<IssuedBook> issuedBooks) {
            this.totalBooks = totalBooks;
            this.totalIssuedBooks = totalIssuedBooks;
            this.overdueBooks = overdueBooks;
            this.books = books;
            this.issuedBooks = issuedBooks;
        }

        // Getters and Setters
        public int getTotalBooks() {
            return totalBooks;
        }

        public void setTotalBooks(int totalBooks) {
            this.totalBooks = totalBooks;
        }

        public int getTotalIssuedBooks() {
            return totalIssuedBooks;
        }

        public void setTotalIssuedBooks(int totalIssuedBooks) {
            this.totalIssuedBooks = totalIssuedBooks;
        }

        public int getOverdueBooks() {
            return overdueBooks;
        }

        public void setOverdueBooks(int overdueBooks) {
            this.overdueBooks = overdueBooks;
        }

        public List<Book> getBooks() {
            return books;
        }

        public void setBooks(List<Book> books) {
            this.books = books;
        }

        public List<IssuedBook> getIssuedBooks() {
            return issuedBooks;
        }

        public void setIssuedBooks(List<IssuedBook> issuedBooks) {
            this.issuedBooks = issuedBooks;
        }
    }
}
