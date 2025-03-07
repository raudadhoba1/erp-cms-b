package com.rd.erp_cms.dto;

public class PermissionDTO {
    private String name;
    private String permissionCode;
    private String permissionPage;

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
