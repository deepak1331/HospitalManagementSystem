package com.learn.jpa.HospitalManagementSystem.dto;

import lombok.Data;

@Data
public class LoginResponseDto {

    private String jwt;
    private String username;
}
