package com.learn.jpa.HospitalManagementSystem.service;

import com.learn.jpa.HospitalManagementSystem.dto.DoctorResponseDTO;
import com.learn.jpa.HospitalManagementSystem.entity.Doctor;
import com.learn.jpa.HospitalManagementSystem.repo.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public List<Doctor>  saveAllDoctor(List<Doctor> doctorList){
        return doctorRepository.saveAll(doctorList);
    }

    public Optional<Doctor> findById(Long doctorId){
        return doctorRepository.findById(doctorId);
    }

    public List<DoctorResponseDTO> getAllDoctors(){
                return doctorRepository.findAll().stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDTO.class))
                .toList();
    }
}
