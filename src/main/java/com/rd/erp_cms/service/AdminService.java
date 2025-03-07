package com.rd.erp_cms.service;

import com.rd.erp_cms.model.Admin;
import com.rd.erp_cms.model.Teacher;
import com.rd.erp_cms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdminService {

    private  AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Optional<Admin> getAdminByUserId(String userID) {
        return adminRepository.findByUserId(userID);
    }
}
