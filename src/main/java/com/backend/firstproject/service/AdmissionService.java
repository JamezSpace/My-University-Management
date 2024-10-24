package com.backend.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.firstproject.repository.AdmissionsRepo;
import com.backend.firstproject.model.admission_management.Admissions;

import java.util.List;

@Service
public class AdmissionService {
    private AdmissionsRepo admissionRepo;

    // example of setter injection
    @Autowired
    public void setAdmissionRepo (AdmissionsRepo repo) {
        admissionRepo = repo
    }

    public List<Admissions> getAllAdmissionApplications () {
        return admissionRepo.findAll();
    }

    public Admissions getAllAdmissionApplicationByApplicationId (Long applicationId) {
        return admissionRepo.fetchAdmissionByApplicationId(Long applicationId);
    }
}
