package com.backend.firstproject.handlers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.backend.firstproject.dto.ErrorDTO;
import com.backend.firstproject.exceptions.ApplicantNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicantNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleApplicantNotFound (ApplicantNotFoundException e) {
        ErrorDTO customError = new ErrorDTO();

        customError.setCode(HttpStatus.NOT_FOUND.value());
        customError.setMessage(e.getMessage());
        customError.setTime(LocalDateTime.now());

        return new ResponseEntity<ErrorDTO>(customError, HttpStatus.NOT_FOUND);
    }
}
