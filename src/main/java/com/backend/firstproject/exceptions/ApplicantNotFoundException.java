package com.backend.firstproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApplicantNotFoundException extends RuntimeException {
    public ApplicantNotFoundException(String msg){
        super(msg);
    }
}
