package com.rd.erp_cms.service;

import com.rd.erp_cms.dto.LibrarianUserDTO;
import com.rd.erp_cms.model.Librarian;
import com.rd.erp_cms.model.User;
import com.rd.erp_cms.repository.LibrarianRepository;
import com.rd.erp_cms.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    // 1. Get all librarians
    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    // 2. Get librarian by userId
    public Optional<Librarian> getLibrarianByUserId(String userId) {
        return librarianRepository.findByUserId(userId);
    }

    // 3. Create a new librarian
    public Librarian createLibrarian(LibrarianUserDTO dto) {
        // Save user
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        userService.createUser(user);

        // Save librarian
        Librarian librarian = new Librarian();
        librarian.setUserId(dto.getUserId());
        librarian.setEmail(dto.getEmail());
        librarian.setPassword(dto.getPassword());
        librarian.setName(dto.getName());
        librarian.setDob(dto.getDob());
        librarian.setAddress(dto.getAddress());
        librarian.setGender(dto.getGender());

        return librarianRepository.save(librarian);
    }

    // 4. Update librarian
    @Transactional
    public Optional<Librarian> updateLibrarian(String userId, Librarian librarian) {
        if (librarianRepository.existsByUserId(userId)) {
            librarian.setUserId(userId);
            return Optional.of(librarianRepository.save(librarian));
        }
        return Optional.empty();
    }

    // 5. Delete librarian
    @Transactional
    public boolean deleteLibrarian(String userId) {
        Optional<Librarian> librarian = librarianRepository.findByUserId(userId);
        Optional<User> user = userRepository.getUserByUserId(userId);

        if (librarian.isPresent() && user.isPresent()) {
            librarianRepository.deleteByUserId(userId);
            userRepository.deleteByUserId(userId);
            return true;
        }
        return false;
    }
}
