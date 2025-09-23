package com.learn.jpa.HospitalManagementSystem.controller;

import com.learn.jpa.HospitalManagementSystem.dto.PatientResponseDto;
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
    public ResponseEntity<List<PatientResponseDto>> findAllPatient(){
        return ResponseEntity.ok(patientService.findAllPatient());
    }

    @GetMapping(path = "/{patientId}")
    public ResponseEntity<PatientResponseDto> findPatientById(@PathVariable Long patientId){
        return ResponseEntity.ok(patientService.findById(patientId));
    }
}
