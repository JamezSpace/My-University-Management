package com.backend.firstproject.controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.backend.firstproject.model.admission_management.Admissions;
import com.backend.firstproject.service.AdmissionService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
public class AdmissionController {
    private final AdmissionService addService;
    
    @Autowired
    public AdmissionController(AdmissionsRepo addService) {
        this.addService = addService;
    }

    @GetMapping("/admissions")
    public List<Admissions> getApplicantById() {
        return addService.getAllAdmissionApplications();
    }

    @GetMapping("/admissions/{applicationId}")
    public Admissions getAdmissionByAppId(@PathVariable Long applicationId) {
        return addService.getAllAdmissionApplicationByApplication(applicationId)
                             .orElseThrow(() -> new ResourceNotFoundException("Admission not found"));
    }

}