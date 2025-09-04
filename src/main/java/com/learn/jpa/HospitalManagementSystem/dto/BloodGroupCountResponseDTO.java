package com.learn.jpa.HospitalManagementSystem.dto;

import com.learn.jpa.HospitalManagementSystem.constant.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BloodGroupCountResponseDTO {

    private BloodGroupType bloodGroupType;
    private Long count;
}
