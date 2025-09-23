package com.learn.jpa.HospitalManagementSystem;

import com.learn.jpa.HospitalManagementSystem.dto.AppointmentResponseDto;
import com.learn.jpa.HospitalManagementSystem.dto.CreateAppointmentRequestDto;
import com.learn.jpa.HospitalManagementSystem.entity.Appointment;
import com.learn.jpa.HospitalManagementSystem.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment(){

        CreateAppointmentRequestDto appointmentRequestDTO = CreateAppointmentRequestDto.builder()
                .doctorId(4L)
                .patientId(4L)
                .reason("Toothache")
                .appointmentTime(LocalDateTime.of(2025, 9, 13, 18, 30))
                .build();

        AppointmentResponseDto updatedAppointment = appointmentService.createNewAppointment(appointmentRequestDTO);
        System.out.printf("New Appointment Created : %s", updatedAppointment);
        Assert.notNull(updatedAppointment, "Appointment not null");
    }

    @Test
    public void testReassignAppointment() {
        Appointment updatedAppointment = appointmentService.reassignAppointment(1L, 1L);
        System.out.println(updatedAppointment);
        Assert.notNull(updatedAppointment, "Not Null");
    }
}
