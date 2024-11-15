package com.backend.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.firstproject.repository.AdmissionsRepo;
import com.backend.firstproject.repository.ApplicantsRepo;
import com.backend.firstproject.dto.AdmissionsDTO;
import com.backend.firstproject.exceptions.ApplicantNotFoundException;
import com.backend.firstproject.model.admission_management.Admissions;
import com.backend.firstproject.model.admission_management.Applicants;

import java.util.List;

@Service
public class AdmissionService {
    private AdmissionsRepo admissionRepo;

    @Autowired
    private ApplicantsRepo applicantsRepo;

    // example of setter injection
    @Autowired
    public void setAdmissionRepo (AdmissionsRepo repo) {
        admissionRepo = repo;
    }

    private Applicants getApplication(int id) {
        Applicants applicant = applicantsRepo.findByApplicationId(id);

        if (applicant == null) throw new ApplicantNotFoundException("Applicant with id, " + id + " does not exist!");

        return applicant;
    }

    public List<Admissions> getAllAdmissionApplications () {
        return admissionRepo.findAll();
    }

    public Admissions getAdmissionApplicationByApplicationId (int applicationId) {
        // verify if applicant exists
        getApplication(applicationId);

        return admissionRepo.findAdmissionsByApplicationId(applicationId);
    }

    public Admissions addNewAdmission(AdmissionsDTO newAdmission) {
        Applicants applicant = getApplication(newAdmission.getApplicantId());

        Admissions admission = new Admissions();
        admission.setApplicant(applicant);
        admission.setAdmissionStatus(newAdmission.getAdmissionStatus());
        admission.setApplicationDate(newAdmission.getApplicationDate());
        admission.setApplicationType(newAdmission.getApplicationType());

        return admissionRepo.save(admission);
    }

    public Admissions editAdmission(int id, Admissions edit) {
        Admissions existingAdmission = admissionRepo.findAdmissionsByApplicationId(id);
        
        existingAdmission.setAdmissionStatus(edit.getAdmissionStatus());
        existingAdmission.setApplicationDate(edit.getApplicationDate());
        existingAdmission.setApplicationType(edit.getApplicationType());

        return admissionRepo.save(existingAdmission);
    }
}
