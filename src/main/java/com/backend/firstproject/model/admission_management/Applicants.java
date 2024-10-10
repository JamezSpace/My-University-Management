package com.backend.firstproject.model.admission_management;

import java.io.Serializable;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.backend.firstproject.model.Constants;

@Entity
@Table(name = "applicants")
public class Applicants implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applicationId;

    @Column(name = "first_name", nullable = false)
    private String studentFirstName;

    @Column(name = "last_name", nullable = false)
    private String studentLastName;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    private Constants.Gender gender;

    @Column(unique = true, nullable = false)
    private String studentEmail;

    @Column(name = "phone_num")
    private String studentPhoneNum;

    private String nationality;

    @Column(name = "address")
    private String studentAddress;

    private String password;

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public void setGender(Constants.Gender gender) {
        this.gender = gender;
    }

    public Constants.Gender getGender() {
        return gender;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void setStudentPhoneNum(String studentPhoneNum) {
        this.studentPhoneNum = studentPhoneNum;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentPhoneNum() {
        return studentPhoneNum;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

}
