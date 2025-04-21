package com.rd.erp_cms.dto;

import com.rd.erp_cms.model.Librarian;
import com.rd.erp_cms.model.Student;
import com.rd.erp_cms.model.User;

import java.time.LocalDate;
import java.util.Date;

public class LibrarianUserDTO {
    private String userId;
    private String email;
    private String password;
    private String name;
    private Date dob;
    private String address;
    private Librarian.Gender gender;
    private String organization;
    private User.Role role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Librarian.Gender getGender() {
        return gender;
    }

    public void setGender(Librarian.Gender gender) {
        this.gender = gender;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }
}
