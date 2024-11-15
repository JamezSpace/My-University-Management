package com.backend.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.firstproject.model.admission_management.Applicants;
import java.util.List;

@Repository
public interface ApplicantsRepo extends JpaRepository<Applicants, Integer>{
    Applicants findByApplicationId(int applicationId);
    List<Applicants> findByFirstName(String firstName);
    List<Applicants> findByLastName(String lastName);
}
