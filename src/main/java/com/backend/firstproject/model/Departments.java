package com.backend.firstproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// @Entity
public class Departments {
    @Id
    private Long facultyId;
    private Long departmentId;
    private Long departmentName;
    private Long hodId;

    public Long getDepartmentId() {
        return departmentId;
    }

    public Long getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(Long departmentName) {
        this.departmentName = departmentName;
    }

    public void setHodId(Long hodId) {
        this.hodId = hodId;
    }

}
