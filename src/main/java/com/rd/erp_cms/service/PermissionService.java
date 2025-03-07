package com.rd.erp_cms.service;

import com.rd.erp_cms.dto.PermissionDTO;
import com.rd.erp_cms.model.Permission;
import com.rd.erp_cms.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    public List<PermissionDTO> getPermissionsByRole(String role) {
        return permissionRepository.findByRole(role).stream()
                .map(permission -> {
                    PermissionDTO dto = new PermissionDTO();
                    dto.setName(permission.getName());
                    dto.setPermissionCode(permission.getPermissionCode());
                    dto.setPermissionPage(permission.getPermissionPage());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
