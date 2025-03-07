package com.rd.erp_cms.dto;

import com.rd.erp_cms.model.Teacher;
import com.rd.erp_cms.model.User;

import java.util.Date;

public class TeacherUserDTO {
    private String userId;
    private String name;
    private String email;
    private String password;
    private User.Role role;
    private Date dob;
    private String address;
    private String qualification;
    private Teacher.Gender gender;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Teacher.Gender getGender() {
        return gender;
    }

    public void setGender(Teacher.Gender gender) {
        this.gender = gender;
    }
}
