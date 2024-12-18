package com.backend.firstproject.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private Integer code;
    private String summary;
    private String message;
    private LocalDateTime time; 
}
