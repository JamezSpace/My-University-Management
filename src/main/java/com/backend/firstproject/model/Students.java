package com.backend.firstproject.model;

import jakarta.persistence.Id;

public class Students {
    @Id
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNum;
    private String address;
    private String password;
    private String dateOfBirth;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

}
