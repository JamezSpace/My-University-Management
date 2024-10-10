package com.backend.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.firstproject.model.admission_management.Applicants;
import java.util.List;

@Repository
public interface ApplicantsRepo extends JpaRepository<Applicants, Long>{
    Applicants findByApplicationId(Long applicationId);
    List<Applicants> findByStudentLastName(String studentLastName);
    List<Applicants> findByStudentFirstName(String studentFirstName);
}
