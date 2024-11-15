package com.backend.firstproject.model.admission_management;

import java.time.LocalDateTime;

import com.backend.firstproject.model.Constants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "admissions")
@NoArgsConstructor
@AllArgsConstructor
public class Admissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sn;

    @JoinColumn(unique = true)
    @OneToOne(cascade=CascadeType.ALL, optional = false)
    private Applicants applicant;

    @Column(name = "application_date")
    private LocalDateTime applicationDate;

    @Column(name = "admission_status")
    @Enumerated(EnumType.STRING)
    private Constants.AdmissionStatus admissionStatus;

    @Column(name = "application_type")
    @Enumerated(EnumType.STRING)
    private Constants.EntryType applicationType;

    // TODO: exam ID to be put in here
}
