package com.learn.jpa.HospitalManagementSystem.dto;


import com.learn.jpa.HospitalManagementSystem.entity.type.BloodGroupType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientResponseDTO {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private BloodGroupType bloodGroup;
}