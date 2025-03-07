package com.rd.erp_cms.controller;

import com.rd.erp_cms.dto.TeacherUserDTO;
import com.rd.erp_cms.model.Teacher;
import com.rd.erp_cms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Teacher> getTeacherByUserId(@PathVariable String userId) {
        Optional<Teacher> teacher = teacherService.getTeacherByUserId(userId);
        return teacher.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher(@RequestBody TeacherUserDTO teacherUserDTO) {
        Teacher savedTeacher = teacherService.addTeacher(teacherUserDTO);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{userId}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable String userId, @RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacher(userId, teacher);
        if (updatedTeacher != null) {
            return ResponseEntity.ok(updatedTeacher);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable String userId) {
        boolean isDeleted = teacherService.deleteTeacher(userId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
