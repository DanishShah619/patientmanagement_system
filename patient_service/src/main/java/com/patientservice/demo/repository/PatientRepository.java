package com.patientservice.demo.repository;


import com.patientservice.demo.model.Patient;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {


    boolean existsByEmail(@NotBlank(message = "cannot be blank") @Email(message = "email should be valid") String email);

    boolean existsByEmailAndIdNot(@NotBlank(message = "cannot be blank") @Email(message = "email should be valid") String email, UUID id);
}
