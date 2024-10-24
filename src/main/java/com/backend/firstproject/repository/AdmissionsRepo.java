package com.backend.firstproject.repository;


import org.springframework.data.jpa.repository.JpaRepository; 

import org.springframework.stereotype.Repository;


import com.backend.firstproject.model.admission_management.Admissions; 

@Repository
public interface AdmissionsRepo extends JpaRepository<Admissions, Integer> {
    Admissions fetchAdmissionByApplicationId(Long applicationId);
}