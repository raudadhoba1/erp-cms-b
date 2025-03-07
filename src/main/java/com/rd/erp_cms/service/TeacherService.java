package com.rd.erp_cms.service;

import com.rd.erp_cms.dto.TeacherUserDTO;
import com.rd.erp_cms.model.Teacher;
import com.rd.erp_cms.model.User;
import com.rd.erp_cms.repository.TeacherRepository;
import com.rd.erp_cms.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // Get all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // For getting profile details
    public Optional<Teacher> getTeacherByUserId(String userID) {
        return teacherRepository.findByUserId(userID);
    }

    // Add a new teacher
    public Teacher addTeacher(TeacherUserDTO teacherUserDTO) {
        // Create new user
        User user = new User();
        user.setUserId(teacherUserDTO.getUserId());
        user.setEmail(teacherUserDTO.getEmail());
        user.setPassword(teacherUserDTO.getPassword());
        user.setRole(teacherUserDTO.getRole());

        userService.createUser(user);  // Create user in UserService

        // Create new teacher
        Teacher teacher = new Teacher();
        teacher.setUserId(teacherUserDTO.getUserId());
        teacher.setEmail(teacherUserDTO.getEmail());
        teacher.setPassword(teacherUserDTO.getPassword());
        teacher.setName(teacherUserDTO.getName());
        teacher.setDob(teacherUserDTO.getDob());
        teacher.setAddress(teacherUserDTO.getAddress());
        teacher.setQualification(teacherUserDTO.getQualification());
        teacher.setGender(teacherUserDTO.getGender());

        return teacherRepository.save(teacher);  // Save teacher
    }

    @Transactional
    public boolean deleteTeacher(String userId) {
        Optional<Teacher> teacher = teacherRepository.findByUserId(userId);
        Optional<User> user = userRepository.getUserByUserId(userId);

        if (teacher.isPresent() && user.isPresent()) {
            // Delete the teacher first to avoid foreign key violation
            teacherRepository.deleteByUserId(userId);  // Delete teacher by userId

            // Then delete the user
            userRepository.deleteByUserId(userId);  // Delete user by userId
            return true;
        }

        return false;  // If teacher or user doesn't exist
    }


    @Transactional
    public Teacher updateTeacher(String userId, Teacher teacher) {
        // Check if the user exists in the User table
        Optional<User> existingUserOpt = userRepository.getUserByUserId(userId);
        if (!existingUserOpt.isPresent()) {
            throw new EntityNotFoundException("User with userId " + userId + " does not exist");
        }

        // Check if the teacher exists in the Teacher table
        Optional<Teacher> existingTeacherOpt = teacherRepository.findByUserId(userId);
        if (!existingTeacherOpt.isPresent()) {
            throw new EntityNotFoundException("Teacher with userId " + userId + " does not exist");
        }

        // Proceed to update the teacher and user
        Teacher existingTeacher = existingTeacherOpt.get();
        User existingUser = existingUserOpt.get();

        // Update teacher fields
        existingTeacher.setName(teacher.getName());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setAddress(teacher.getAddress());
        existingTeacher.setGender(teacher.getGender());
        existingTeacher.setQualification(teacher.getQualification());
        existingTeacher.setDob(teacher.getDob());
        existingTeacher.setPassword(teacher.getPassword()); // Assuming you also want to update the password

        // Update user fields
        existingUser.setEmail(teacher.getEmail()); // You may not want to update userId if it's not changing
        existingUser.setPassword(teacher.getPassword());

        // Save updated user and teacher (both are updated simultaneously within the transaction)
        userRepository.save(existingUser);  // Save updated user entity
        return teacherRepository.save(existingTeacher);  // Save updated teacher entity
    }



}
