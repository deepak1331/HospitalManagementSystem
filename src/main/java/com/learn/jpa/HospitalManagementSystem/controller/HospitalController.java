package com.learn.jpa.HospitalManagementSystem.controller;

import com.learn.jpa.HospitalManagementSystem.dto.DoctorResponseDto;
import com.learn.jpa.HospitalManagementSystem.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class HospitalController {

    private final DoctorService doctorService;

    @GetMapping(value = "/doctors")
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }
}
