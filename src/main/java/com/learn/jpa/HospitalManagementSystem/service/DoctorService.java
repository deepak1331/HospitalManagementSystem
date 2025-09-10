package com.learn.jpa.HospitalManagementSystem.service;

import com.learn.jpa.HospitalManagementSystem.entity.Doctor;
import com.learn.jpa.HospitalManagementSystem.repo.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public List<Doctor>  saveAllDoctor(List<Doctor> doctorList){
        return doctorRepository.saveAll(doctorList);
    }

    public Optional<Doctor> findById(Long doctorId){
        return doctorRepository.findById(doctorId);
    }
}
