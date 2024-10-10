package com.backend.firstproject.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.backend.firstproject.model.admission_management.Applicants;
import com.backend.firstproject.service.ApplicantsService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 
@RestController
public class ApplicantsController {
    @Autowired
    private ApplicantsService applicantsService;

    @GetMapping("/applicants")
    public List<Applicants> getAllApplicants() {
        return applicantsService.getAllApplicants();
    }

    @GetMapping("/applicants/{id}")
    public Applicants getApplicant(@PathVariable Long id) {
        return applicantsService.geApplicant(id);
    }

    @PutMapping("/applicants/{id}")
    public Applicants editApplicantsDetails(@PathVariable Long id, @RequestBody Applicants edit) {
        // TODO: process PUT request

        return applicantsService.editApplicantDetails(id, edit);
    }

    @PostMapping("/applicants")
    public Applicants addApplicant(@RequestBody Applicants newApplicant) {
        return applicantsService.addApplicant(newApplicant);
    }

    @DeleteMapping("/applicants/{id}")
    public String deleteApplicant(@PathVariable Long id) {
        boolean deleted = applicantsService.deleteApplicant(id);

        if (deleted)
            return "Deleted Applicant Successfully";
        return "Applicant doesn't exist.";
    }

}
