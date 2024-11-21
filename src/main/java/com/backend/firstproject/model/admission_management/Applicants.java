package com.backend.firstproject.model.admission_management;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.backend.firstproject.model.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "applicants")
public class Applicants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationId;

    @NotBlank(message = "First name is necessary, it cannot be blank")
    @Length(min = 3, message = "Enter a valid name")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is necessary, it cannot be blank")
    @Length(min = 3, message = "Enter a valid name")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotNull(message = "Provide your gender")
    @Length(min = 4, max = 6, message = "Enter a valid gender")
    @Enumerated(EnumType.STRING)
    private Constants.Gender gender;

    @Email(message = "Enter a valid email")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Supply a valid phone number")
    @Column(name = "phone_num")
    private String phoneNum;

    @NotBlank(message = "Supply your valid nationality")
    private String nationality;

    @NotBlank(message = "Your address is needed, cannot be blank")
    private String address;
}
