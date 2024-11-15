package com.backend.firstproject.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.firstproject.dto.AdmissionsDTO;
import com.backend.firstproject.model.admission_management.Admissions;
import com.backend.firstproject.service.AdmissionService;


@RestController
@RequestMapping("/api/admissions")
public class AdmissionController {
    private final AdmissionService addService;
    
    public AdmissionController(AdmissionService addService) {
        this.addService = addService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Admissions>> getAllAdmissions() {
        List<Admissions> allAdmissions = addService.getAllAdmissionApplications();
        
        return new ResponseEntity<>(allAdmissions, HttpStatus.OK);
    }

    @RequestMapping(params = "applicationId")
    public ResponseEntity<Admissions> getAdmissionByApplicationId(@RequestParam int applicationId) {
        Admissions admission = addService.getAdmissionApplicationByApplicationId(applicationId);
        
        if (admission == null) return ResponseEntity.notFound().build();

        return new ResponseEntity<Admissions> (admission, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Admissions> postNewAdmission(@RequestBody AdmissionsDTO newAdmission) {
        Admissions savedAdmission = addService.addNewAdmission(newAdmission);
        
        return new ResponseEntity<>(savedAdmission, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admissions> editAdmissions(@PathVariable int id, @RequestBody Admissions admission) {
        Admissions existingAdmission = addService.getAdmissionApplicationByApplicationId(id);
        
        if (existingAdmission == null) return ResponseEntity.notFound().build();
        
        Admissions edited = addService.editAdmission(id, admission);

        return new ResponseEntity<Admissions>(edited, HttpStatus.OK);
    }
    

}