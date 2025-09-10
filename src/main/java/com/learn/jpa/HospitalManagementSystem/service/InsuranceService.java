package com.learn.jpa.HospitalManagementSystem.service;

import com.learn.jpa.HospitalManagementSystem.entity.Insurance;
import com.learn.jpa.HospitalManagementSystem.entity.Patient;
import com.learn.jpa.HospitalManagementSystem.repo.InsuranceRepository;
import com.learn.jpa.HospitalManagementSystem.repo.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;


    @Transactional
    public Patient attachInsuranceToPatient(Insurance insurance, Long patientId) {

        Patient patient = patientRepository.findPatientById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("No patient found with ID: " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); //this is done to maintain Bi-directional mapping

        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId) {

        Patient patient = patientRepository.findPatientById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("No patient found with ID: " + patientId));

        patient.setInsurance(null); //this will remove Insurance reference from patient,
        // and insurance will become an Orphan object
        return patient;
    }

    @Transactional
    public Patient updateInsuranceToPatient( Insurance newInsurance, Long patientId) {

        Patient patient = patientRepository.findPatientById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("No patient found with ID: " + patientId));
        if (patient.getInsurance() != null)
            patient.setInsurance(null);  //removing reference to existing insurance

        patient.setInsurance(newInsurance);
        newInsurance.setPatient(patient); //this is done to maintain Bi-directional mapping

        return patient;
    }


}
