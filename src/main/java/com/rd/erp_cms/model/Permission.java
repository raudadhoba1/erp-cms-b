package com.rd.erp_cms.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

@Entity
@Table(name = "role_permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role")
    private String role;
    @Column(name = "name")
    private String name;
    @Column(name = "permission_code")
    private String permissionCode;

    @Column(name = "permission_page")
    private String permissionPage;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionPage() {
        return permissionPage;
    }

    public void setPermissionPage(String permissionPage) {
        this.permissionPage = permissionPage;
    }
}