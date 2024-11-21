package com.backend.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.firstproject.repository.AdmissionsRepo;
import com.backend.firstproject.repository.ApplicantsRepo;
import com.backend.firstproject.dto.AdmissionsDTO;
import com.backend.firstproject.exceptions.AdmissionExistsException;
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
        int applicantId = newAdmission.getApplicantId();
        
        Admissions existingAdmission = getAdmissionApplicationByApplicationId(applicantId);

        if(existingAdmission != null) throw new AdmissionExistsException("Admission details for applicant ID: " + applicantId + " exists already.");

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

    public boolean deleteAdmission(int applicationId) {
        int admissionSn = getAdmissionApplicationByApplicationId(applicationId).getSn();
        
        try {
            admissionRepo.deleteById(admissionSn);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }
}
