package com.patientservice.demo.mapper;

import com.patientservice.demo.dto.PatientResponseDTO;
import com.patientservice.demo.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDto(Patient patient) {
         PatientResponseDTO patientDTO = new PatientResponseDTO();
         patientDTO.setId(patient.getId().toString());
         patientDTO.setName(patientDTO.getName());
         patientDTO.setAddress(patientDTO.getAddress());
         patientDTO.setEmail(patientDTO.getEmail());
         patientDTO.setDateOfBirth(patientDTO.getDateOfBirth());
         return patientDTO;
    }
}
