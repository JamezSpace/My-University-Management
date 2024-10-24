package com.backend.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.firstproject.repository.ApplicantsRepo;
import com.backend.firstproject.model.admission_management.Applicants;

import java.util.List;

@Service
public class ApplicantsService {
    private ApplicantsRepo applicantsRepository;

    // example of constructor injection
    public ApplicantsService(ApplicantsRepo repo) {
        applicantsRepository = repo;
    }
    
    public List<Applicants> getAllApplicants() {
        return applicantsRepository.findAll();
    }

    public Applicants getApplicant(Long id) {
        return applicantsRepository.findByApplicationId(id);
    }

    public Applicants editApplicantDetails(Long id, Applicants edit) {
        if(!applicantsRepository.existsById(id)) return null;
        return applicantsRepository.findById(id).orElse(null);
    }

    public Applicants addApplicant(Applicants newApplicant) {
        return applicantsRepository.save(newApplicant);
    }

    public boolean deleteApplicant(Long id) {
        boolean deleted = false;

        if(!applicantsRepository.existsById(id)) return deleted;
        
        applicantsRepository.deleteById(id);

        return !deleted;
    }
}
