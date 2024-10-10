package com.backend.firstproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;

    public String getlastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}