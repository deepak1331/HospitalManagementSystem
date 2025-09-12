package com.learn.jpa.HospitalManagementSystem.controller;

import com.learn.jpa.HospitalManagementSystem.dto.PatientResponseDTO;
import com.learn.jpa.HospitalManagementSystem.entity.Doctor;
import com.learn.jpa.HospitalManagementSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final PatientService patientService;

    @GetMapping(value = "/patients")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.findAllPatient());
    }

    @GetMapping(value = "/patient")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients(
    @RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
    @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(patientService.findAllPatient(pageNumber, pageSize));
    }

/*
    @PostMapping("/onBoardNewDoctor")
    public ResponseEntity<DoctorResponseDTO> onBoardNewDoctor(@RequestBody Doctor doctor){

    }*/

}
