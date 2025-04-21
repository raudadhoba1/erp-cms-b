package com.rd.erp_cms.controller;



import com.rd.erp_cms.dto.LibrarianUserDTO;
import com.rd.erp_cms.model.Librarian;
import com.rd.erp_cms.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @PostMapping("/add")
    public ResponseEntity<Librarian> createLibrarian(@RequestBody LibrarianUserDTO librarianUserDTO) {
        Librarian savedLibrarian = librarianService.createLibrarian(librarianUserDTO);
        return new ResponseEntity<>(savedLibrarian, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Librarian> getLibrarianByUserId(@PathVariable String userId) {
        Optional<Librarian> librarian = librarianService.getLibrarianByUserId(userId);
        return librarian.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<Librarian> updateLibrarian(@PathVariable String userId, @RequestBody Librarian librarian) {
        Optional<Librarian> updatedLibrarian = librarianService.updateLibrarian(userId, librarian);
        return updatedLibrarian.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteLibrarian(@PathVariable String userId) {
        boolean isDeleted = librarianService.deleteLibrarian(userId);
        return isDeleted ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Librarian>> getAllLibrarians() {
        List<Librarian> librarians = librarianService.getAllLibrarians();
        return ResponseEntity.ok(librarians);
    }
}

