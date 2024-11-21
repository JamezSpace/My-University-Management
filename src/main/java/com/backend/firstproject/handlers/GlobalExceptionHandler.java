package com.backend.firstproject.handlers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.backend.firstproject.dto.ErrorDTO;
import com.backend.firstproject.exceptions.AdmissionExistsException;
import com.backend.firstproject.exceptions.ApplicantNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private ErrorDTO populateCustomError(
        HttpStatus statusCode, String summary, String message
    ) {
        ErrorDTO customError = new ErrorDTO();
        
        customError.setCode(statusCode.value());
        customError.setSummary(summary.toUpperCase());
        customError.setMessage(message);
        customError.setTime(LocalDateTime.now());

        return customError;
    }

    @ExceptionHandler(ApplicantNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleApplicantNotFound (ApplicantNotFoundException e) {
        ErrorDTO customError = populateCustomError(HttpStatus.NOT_FOUND, "not existing", e.getMessage());

        return new ResponseEntity<ErrorDTO>(customError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AdmissionExistsException.class)
    public ResponseEntity<ErrorDTO> handleExistingAdmissionConflict (AdmissionExistsException e) {
        ErrorDTO customError = populateCustomError(HttpStatus.CONFLICT, "disallowed", e.getMessage());

        return new ResponseEntity<ErrorDTO>(customError, HttpStatus.CONFLICT);
    }
}
