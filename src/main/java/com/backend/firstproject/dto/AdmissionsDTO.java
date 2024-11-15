package com.backend.firstproject.dto;

import java.time.LocalDateTime;

import com.backend.firstproject.model.Constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionsDTO {
    private int applicantId;
    private LocalDateTime applicationDate;
    private Constants.AdmissionStatus admissionStatus;
    private Constants.EntryType applicationType;
}