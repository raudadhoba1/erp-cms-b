package com.rd.erp_cms.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Auto-increment primary key

    @Column(nullable = false, unique = true)
    private String userId;  // Unique identifier for the user

    @Column(nullable = false, unique = true)
    private String email;  // Email address (unique)

    @Column(nullable = false)
    private String password;  // Password

    @Column(nullable = false)
    private String name;  // User's name

    @Column(nullable = false)
    private Date dob;  // Date of birth

    @Column
    private String address;  // Optional address

    @Column
    private String qualification;  // Optional qualification

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;  // Enum for gender (MALE, FEMALE, OTHER)

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
