package com.backend.firstproject.model.admission_management;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "applicants")
public class Applicants implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applicationId;

    private String studentFirstName;
    private String studentLastName;
    private String studentEmail;
    private String studentPhoneNum;
    private String studentAddress;
    private String password;
    private String dateOfBirth;

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
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

    public void setDateOfBirth(String dateOfBirth) {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

}
