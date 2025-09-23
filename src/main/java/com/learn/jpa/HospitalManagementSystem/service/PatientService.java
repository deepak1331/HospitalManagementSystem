package com.learn.jpa.HospitalManagementSystem.service;

import com.learn.jpa.HospitalManagementSystem.dto.PatientResponseDto;
import com.learn.jpa.HospitalManagementSystem.entity.Patient;
import com.learn.jpa.HospitalManagementSystem.repo.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public PatientResponseDto findById(Long id) {
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();
        return modelMapper.map(p2, PatientResponseDto.class);
    }

    public PatientResponseDto findByName(String patientName) {
        return modelMapper.map(patientRepository.findByName(patientName), PatientResponseDto.class);
    }

    public List<PatientResponseDto> findAllPatient() {
        return patientRepository.findAll().stream().map(
                patient -> modelMapper.map(patient, PatientResponseDto.class)
        ).toList();
    }

    public List<PatientResponseDto> findAllPatient(int page, int size) {
        return patientRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDto.class))
                .toList();
    }
}