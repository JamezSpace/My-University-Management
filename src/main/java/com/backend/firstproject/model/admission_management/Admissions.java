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
    private Applicants applicationId;

    private Constants.EntryType applicationType;
    
    private LocalDateTime applicationDate;

    @Column(name = "admission_status")
    private Constants.AdmissionStatus admissionStatus;

    public int getSn() {
        return sn;
    }

    public Applicants getApplicationId() {
        return applicationId;
    }

    public Constants.EntryType getApplicationType() {
        return applicationType;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public Constants.AdmissionStatus getAdmissionStatus() {
        return admissionStatus;
    }

    public void setApplicationType(Constants.EntryType applicationType) {
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
