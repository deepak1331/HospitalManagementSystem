package com.learn.jpa.HospitalManagementSystem.service;

import com.learn.jpa.HospitalManagementSystem.entity.Patient;
import com.learn.jpa.HospitalManagementSystem.repo.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {


    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public Patient findById(Long id) {
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();
        return p2;
    }

    public Patient findByName(String patientName) {
      return patientRepository.findByName(patientName);
    }

    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }
}
