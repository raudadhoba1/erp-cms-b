package com.rd.erp_cms.controller;

import com.rd.erp_cms.model.Admin;
import com.rd.erp_cms.model.Teacher;
import com.rd.erp_cms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/{userID}")
    public ResponseEntity<Admin> getStudentByUserId(@PathVariable String userID) {
        Optional<Admin> admin = adminService.getAdminByUserId(userID);
        return admin.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
