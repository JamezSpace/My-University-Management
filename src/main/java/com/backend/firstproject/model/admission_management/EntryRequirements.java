package com.backend.firstproject.model.admission_management;

import com.backend.firstproject.model.Constants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "entry_requirements")
@NoArgsConstructor
@AllArgsConstructor
public class EntryRequirements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne(cascade=CascadeType.ALL, optional = false)
    @JoinColumn(referencedColumnName = "program_id")
    private Programs program;

    @Enumerated(EnumType.STRING)
    @Column(name="entry_type")
    private Constants.EntryType entryType;

    private Short credits;
}
