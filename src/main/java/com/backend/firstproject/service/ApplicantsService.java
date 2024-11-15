package com.backend.firstproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.firstproject.model.admission_management.Applicants;
import com.backend.firstproject.repository.ApplicantsRepo;

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

    public Applicants getApplicant(int id) {
        return applicantsRepository.findByApplicationId(id);
    }

    @Transactional
    public Applicants editApplicantDetails(int id, Applicants edit) {
        Applicants existingApplicant = applicantsRepository.findByApplicationId(id);
        
        existingApplicant.setAddress(edit.getAddress());
        existingApplicant.setDateOfBirth(edit.getDateOfBirth());
        existingApplicant.setEmail(edit.getEmail());
        existingApplicant.setFirstName(edit.getFirstName());
        existingApplicant.setLastName(edit.getLastName());
        existingApplicant.setGender(edit.getGender());
        existingApplicant.setNationality(edit.getNationality());
        existingApplicant.setPhoneNum(edit.getPhoneNum());

        return applicantsRepository.save(existingApplicant);
    }

    public Applicants addApplicant(Applicants newApplicant) {
        return applicantsRepository.save(newApplicant);
    }

    public List<Applicants> addApplicants(List<Applicants> newApplicants) {
        return applicantsRepository.saveAll(newApplicants);
    }

    public boolean deleteApplicant(int id) {
        boolean deleted = false;

        if(!applicantsRepository.existsById(id)) return deleted;
        
        applicantsRepository.deleteById(id);

        return !deleted;
    }
}
