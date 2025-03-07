package com.rd.erp_cms.controller;

import com.rd.erp_cms.dto.StudentUserDTO;
import com.rd.erp_cms.model.Student;
import com.rd.erp_cms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 1. Create a new student (POST)
    @PostMapping("/add")
    public ResponseEntity<Student> createStudent(@RequestBody StudentUserDTO studentUserDTO) {
        Student savedStudent = studentService.createStudent(studentUserDTO);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // 2. Get student by UserID (GET) for user profile data
    @GetMapping("/{userID}")
    public ResponseEntity<Student> getStudentByUserId(@PathVariable String userID) {
        Optional<Student> student = studentService.getStudentByUserId(userID);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



    // 3. Update student (PUT)
    @PutMapping("/update/{userId}")
    public ResponseEntity<Student> updateStudent(@PathVariable String userId, @RequestBody Student student) {
        Optional<Student> updatedStudent = studentService.updateStudent(userId, student);
        return updatedStudent.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 4. Delete student (DELETE)
    @DeleteMapping("delete/{userId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String userId) {
        boolean isDeleted = studentService.deleteStudent(userId);
        return isDeleted ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Optional: List all students (GET)
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
}
