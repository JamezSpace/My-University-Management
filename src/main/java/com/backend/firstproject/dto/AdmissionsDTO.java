package com.backend.firstproject.dto;

import java.time.LocalDateTime;

import com.backend.firstproject.model.Constants;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionsDTO {
    @NotNull(message = "Applicant ID must be supplied")
    @Positive(message = "Enter a valid applicant ID")
    private int applicantId;

    private LocalDateTime applicationDate = LocalDateTime.now();

    @NotEmpty(message = "Supply a valid admission status")
    private Constants.AdmissionStatus admissionStatus;

    @NotEmpty(message = "Supply a valid application type")
    private Constants.EntryType applicationType;
}