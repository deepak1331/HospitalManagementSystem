package com.learn.jpa.HospitalManagementSystem.controller;

import com.learn.jpa.HospitalManagementSystem.dto.PatientResponseDTO;
import com.learn.jpa.HospitalManagementSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> findAllPatient(){
        return ResponseEntity.ok(patientService.findAllPatient());
    }

    @GetMapping(path = "/{patientId}")
    public ResponseEntity<PatientResponseDTO> findPatientById(@PathVariable Long patientId){
        return ResponseEntity.ok(patientService.findById(patientId));
    }
}
