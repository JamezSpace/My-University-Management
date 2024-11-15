package com.backend.firstproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.firstproject.model.admission_management.Admissions;
 

@Repository
public interface AdmissionsRepo extends JpaRepository<Admissions, Integer> {
    // Admissions fetchAdmissionByApplicationId(Integer applicationId);
    // Admissions findAdmissionsByApplicationId(int applicationId);
    @Query(value = "SELECT adms FROM Admissions adms WHERE adms.applicant.applicationId=:id")                              
    Admissions findAdmissionsByApplicationId(@Param("id") int applicationid);
}