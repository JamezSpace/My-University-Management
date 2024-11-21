package com.backend.firstproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.firstproject.exceptions.ApplicantNotFoundException;
import com.backend.firstproject.model.admission_management.Applicants;
import com.backend.firstproject.service.ApplicantsService;
 
@RestController
@RequestMapping("/api/v1/applicants")
public class ApplicantsController {
    // example of field injection
    @Autowired
    private ApplicantsService applicantsService;

    @GetMapping("/")
    public List<Applicants> getAllApplicants() {
        return applicantsService.getAllApplicants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicants> getApplicant(@PathVariable int id) {
        Applicants applicant = applicantsService.getApplicant(id);

        if (applicant == null) throw new ApplicantNotFoundException("Applicant with id " + id + ", does not exist.");
        
        return new ResponseEntity<Applicants> (applicant, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Applicants> editApplicantsDetails(@PathVariable int id, @RequestBody Applicants edit) {
        // check if applicantId exists
        Applicants applicant = applicantsService.getApplicant(id);

        if (applicant == null) throw new ApplicantNotFoundException("Applicant with id " + id + ", does not exist.");
        
        Applicants editedApplicant = applicantsService.editApplicantDetails(id, edit);

        return new ResponseEntity<Applicants> (editedApplicant, HttpStatus.OK);
    }

    @PostMapping("/single")
    public ResponseEntity<Applicants> addApplicant(
        @RequestHeader(value = "X-Insert-Operation", required = true) String applicantsNum,
        @RequestBody Applicants newApplicant
    ) {
        if (!"single".equalsIgnoreCase(applicantsNum)) return ResponseEntity.badRequest().build();

        Applicants savedApplicant = applicantsService.addApplicant(newApplicant);
        
        return new ResponseEntity<Applicants>(savedApplicant, HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Applicants>> addApplicantsList(
        @RequestHeader(value = "X-Insert-Operation", required = true) String applicantsNum,
        @RequestBody List<Applicants> newApplicants
    ) {
        if (!"bulk".equalsIgnoreCase(applicantsNum)) return ResponseEntity.badRequest().build();
        
        List<Applicants> savedApplicants = applicantsService.addApplicants(newApplicants);

        return new ResponseEntity<>(savedApplicants, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String deleteApplicant(@PathVariable int id) {
        boolean deleted = applicantsService.deleteApplicant(id);

        if (deleted)
            return "Deleted Applicant Successfully";
        return "Applicant doesn't exist.";
    }

}
