package com.patientservice.demo.service;


import com.patientservice.demo.dto.PatientResponseDTO;
import com.patientservice.demo.mapper.PatientMapper;
import com.patientservice.demo.model.Patient;
import com.patientservice.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }
public List<PatientResponseDTO> getPatients (){
        List<Patient> patients = patientRepository.findAll();

    return patients.stream().map(PatientMapper::toDto).toList();
    }

}
