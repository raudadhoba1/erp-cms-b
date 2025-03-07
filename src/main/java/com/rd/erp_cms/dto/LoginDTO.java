package com.rd.erp_cms.dto;

public class LoginDTO {
    private String userIdOrEmail;
    private String password;

    // Getters and Setters
    public String getUserIdOrEmail() {
        return userIdOrEmail;
    }

    public void setUserIdOrEmail(String userIdOrEmail) {
        this.userIdOrEmail = userIdOrEmail; // Consistent parameter name
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
