package com.backend.firstproject.model.admission_management;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExamCredits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String examName;
    private String course;
    private Short points;

    public Long getId() {
        return id;
    }

    public String getExamName() {
        return examName;
    }

    public String getCourse() {
        return course;
    }

    public Short getPoints() {
        return points;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setPoints(Short points) {
        this.points = points;
    }

}
