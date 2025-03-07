package com.rd.erp_cms.service;

import com.rd.erp_cms.dto.StudentUserDTO;
import com.rd.erp_cms.model.Student;
import com.rd.erp_cms.model.User;
import com.rd.erp_cms.repository.StudentRepository;
import com.rd.erp_cms.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    // 1. Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 2. Get student by userId
    public Optional<Student> getStudentByUserId(String userId) {
        return studentRepository.findByUserId(userId);
    }

    // 3. Create a new student
    public Student createStudent(StudentUserDTO studentUserDTO) {
        // Create and save user entity
        User user = new User();
        user.setUserId(studentUserDTO.getUserId());
        user.setEmail(studentUserDTO.getEmail());
        user.setPassword(studentUserDTO.getPassword());
        user.setRole(studentUserDTO.getRole());

        userService.createUser(user);  // Save user to the database

        // Create and save student entity
        Student student = new Student();
        student.setUserId(studentUserDTO.getUserId());
        student.setEmail(studentUserDTO.getEmail());
        student.setPassword(studentUserDTO.getPassword());
        student.setName(studentUserDTO.getName());
        student.setDob(studentUserDTO.getDob());
        student.setAddress(studentUserDTO.getAddress());
        student.setGender(studentUserDTO.getGender());
        student.setProgram(studentUserDTO.getProgram());

        return studentRepository.save(student);  // Save student to the database
    }

    // 4. Update student
    @Transactional
    public Optional<Student> updateStudent(String userId, Student student) {
        // Check if student exists, then update
        if (studentRepository.existsByUserId(userId)) {
            student.setUserId(userId);  // Set userId for the student to ensure it's being updated correctly
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();  // Return empty if the student doesn't exist
    }

    // 5. Delete student
    @Transactional
    public boolean deleteStudent(String userId) {
        Optional<Student> student = studentRepository.findByUserId(userId);
        Optional<User> user = userRepository.getUserByUserId(userId);

        if (student.isPresent() && user.isPresent()) {
            // Delete student and user by userId
            studentRepository.deleteByUserId(userId);
            userRepository.deleteByUserId(userId);
            return true;
        }

        return false;  // Return false if the student or user doesn't exist
    }
}
