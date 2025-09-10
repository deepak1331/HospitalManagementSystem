package com.learn.jpa.HospitalManagementSystem;

import com.learn.jpa.HospitalManagementSystem.entity.Doctor;
import com.learn.jpa.HospitalManagementSystem.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class DoctorTest {

    @Autowired
    private DoctorService doctorService;

    @Test
    public void testSaveDoctor(){

        Doctor doctor = Doctor.builder().name("Dr. Manish Mehra")
                .specialization("Pediatrics")
                .email("manish012@gmail.com")
                .build();

        Assert.notNull(doctorService.saveDoctor(doctor), "Not null");

    }

    @Test
    public void testAllSaveDoctor(){
        Doctor doctor1 = Doctor.builder().name("Dr. Hema")
                .specialization("Pediatrics")
                .email("hema@newgen.com")
                .build();

        Doctor doctor2 = Doctor.builder().name("Dr. U B Yadav")
                .specialization("Orthopedic")
                .email("ubyadav@gmail.com")
                .build();

        Doctor doctor3 = Doctor.builder().name("Dr. Vandana")
                .specialization("Dental")
                .email("vandana@hotmail.com")
                .build();

        Doctor doctor4 = Doctor.builder().name("Dr. Satheesh Mucha")
                .specialization("ENT")
                .email("satheesh@yahoo.com")
                .build();

        Doctor doctor5 = Doctor.builder().name("Dr. Madhu Latha")
                .specialization("Gynaecology")
                .email("madhu_latha@gmail.com")
                .build();

        Assert.notEmpty(doctorService.saveAllDoctor(
                List.of(doctor1, doctor2, doctor3, doctor4, doctor5)),"Not null");
    }
}
