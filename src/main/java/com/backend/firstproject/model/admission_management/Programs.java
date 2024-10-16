package com.backend.firstproject.model.admission_management;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Programs {
    @Id
    private String programId;

    private String name;
    private String level; // level is within 'undergraduate' or 'graduate'
    private Byte duration;
    
    // private String entryType; // first-year or direct-entry for 'undergraduate' level
    
    // public void setEntryType(String entryType) {
    //     this.entryType = entryType;
    // }

    // public String getEntryType() {
    //     return entryType;
    // }

    public String getProgramId() {
        return programId;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public Byte getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setDuration(Byte duration) {
        this.duration = duration;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

}
