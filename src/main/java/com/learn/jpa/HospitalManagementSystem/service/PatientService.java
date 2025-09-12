package com.learn.jpa.HospitalManagementSystem.service;

import com.learn.jpa.HospitalManagementSystem.dto.PatientResponseDTO;
import com.learn.jpa.HospitalManagementSystem.entity.Patient;
import com.learn.jpa.HospitalManagementSystem.repo.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public PatientResponseDTO findById(Long id) {
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();
        return modelMapper.map(p2, PatientResponseDTO.class);
    }

    public PatientResponseDTO findByName(String patientName) {
        return modelMapper.map(patientRepository.findByName(patientName), PatientResponseDTO.class);
    }

    public List<PatientResponseDTO> findAllPatient() {
        return patientRepository.findAll().stream().map(
                patient -> modelMapper.map(patient, PatientResponseDTO.class)
        ).toList();
    }

    public List<PatientResponseDTO> findAllPatient(int page, int size) {
        return patientRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDTO.class))
                .toList();
    }
}