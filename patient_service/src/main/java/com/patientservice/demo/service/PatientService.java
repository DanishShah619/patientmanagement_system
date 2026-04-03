package com.patientservice.demo.service;


import com.patientservice.demo.dto.PatientRequestDTO;
import com.patientservice.demo.dto.PatientResponseDTO;
import com.patientservice.demo.exception.EmailAlreadyExistsException;
import com.patientservice.demo.mapper.PatientMapper;
import com.patientservice.demo.model.Patient;
import com.patientservice.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(PatientMapper::toDto).toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {

        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException(
                    "A patient with this email " + "already exists"
                            + patientRequestDTO.getEmail());
        }
        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDTO));


        return PatientMapper.toDto(newPatient);
    }
}
