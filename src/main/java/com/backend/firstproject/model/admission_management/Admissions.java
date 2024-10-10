package com.backend.firstproject.model.admission_management;

import java.time.LocalDateTime;

import com.backend.firstproject.model.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Admissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sn;

    @JoinColumn(name = "application_id", referencedColumnName = "applicationId")
    private Applicants application;

    private String applicationType; // applicationType varies between first-year-entry, direct-entry and degree-topup
    
    private LocalDateTime applicationDate;

    @Column(name = "admission_status")
    private Constants.AdmissionStatus admissionStatus;

    public Long getApplicationId() {
        return application.getApplicationId();
    }

    public String getApplicationType() {
        return applicationType;
    }

    public String getApplicationDate() {
        return applicationDate.toString();
    }

    public Constants.AdmissionStatus getAdmissionStatus() {
        return admissionStatus;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    // @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setApplicationDate(String applicationDate) {
        this.applicationDate = LocalDateTime.parse(applicationDate);
    }

    public void setAdmissionStatus(Constants.AdmissionStatus admissionStatus) {
        this.admissionStatus = admissionStatus;
    }

}
