package com.rd.erp_cms.controller;

import com.rd.erp_cms.repository.ProgramRepository;
import com.rd.erp_cms.repository.StudentRepository;
import com.rd.erp_cms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// DashboardController.java
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private ProgramRepository programRepo;

    @Autowired
    private TeacherRepository teacherRepository;

    // Endpoint to get the total student count
    @GetMapping("/total-students")
    public ResponseEntity<Long> getTotalStudentCount() {
        long totalStudents = studentRepo.count();
        return ResponseEntity.ok(totalStudents);  // Respond with the total student count
    }

    @GetMapping("/total-programs")
    public ResponseEntity<Long> getTotalProgramCount() {
        long totalPrograms = programRepo.count();
        return ResponseEntity.ok(totalPrograms);  // Respond with the total program count
    }

    @GetMapping("/total-faculty")
    public ResponseEntity<Long> getTotalFacultyCount() {
        long totalFaculty = teacherRepository.count();
        return ResponseEntity.ok(totalFaculty);  // Respond with the total faculty count
    }
}
