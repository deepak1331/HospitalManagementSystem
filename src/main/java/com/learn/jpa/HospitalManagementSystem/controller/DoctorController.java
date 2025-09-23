package com.learn.jpa.HospitalManagementSystem.controller;

import com.learn.jpa.HospitalManagementSystem.dto.AppointmentResponseDto;
import com.learn.jpa.HospitalManagementSystem.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final AppointmentService appointmentService;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/appointments/{doctorId}")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointmentsOfDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(appointmentService.getAllAppointmentsOfDoctor(doctorId));
    }
}
