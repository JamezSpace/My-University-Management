package com.backend.firstproject.model.admission_management;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class EntryRequirements {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long entryRequirementsId;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id", referencedColumnName = "programId")
    private Programs program;

    private String entryType;
    private Short credits;

    public Long getEntryRequirementsId() {
        return entryRequirementsId;
    }

    public String getProgramId() {
        return program.getProgramId();
    }

    public String getEntryType() {
        return entryType;
    }

    public Short getCredits() {
        return credits;
    }

    public void setProgram(Programs program) {
        this.program = program;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public void setCredits(Short credits) {
        this.credits = credits;
    }

}