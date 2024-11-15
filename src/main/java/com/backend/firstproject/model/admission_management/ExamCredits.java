package com.backend.firstproject.model.admission_management;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "credits")
public class ExamCredits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="exam_name")
    private String examName;
    
    private String course;
    private Short points;

    public int getId() {
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
