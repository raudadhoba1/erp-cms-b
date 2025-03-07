package com.rd.erp_cms.controller;

import com.rd.erp_cms.dto.PermissionDTO;
import com.rd.erp_cms.model.Permission;
import com.rd.erp_cms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/role/{role}")
    public List<PermissionDTO> getPermissionsByRole(@PathVariable String role) {
        return permissionService.getPermissionsByRole(role);
    }
}
