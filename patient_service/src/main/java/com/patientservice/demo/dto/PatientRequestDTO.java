package com.patientservice.demo.dto;

import com.patientservice.demo.dto.validators.CreatePatientValidationmGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PatientRequestDTO {

    @NotBlank(message = "cannot be blank")
    @Size(max = 100, message = "name cannot be that long")
private String name;

    @NotBlank(message = "cannot be blank")
    @Email(message = "email should be valid")
    private  String email;

    @NotBlank(message = "address required")
    private  String address;
     @NotBlank
    private String dateOfBirth;
     @NotBlank(groups = CreatePatientValidationmGroup.class)
    private String registeredDate;


}
