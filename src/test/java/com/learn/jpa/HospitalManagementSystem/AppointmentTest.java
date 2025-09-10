package com.learn.jpa.HospitalManagementSystem;

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

        Appointment appointment = Appointment.builder()
                .reason("Toothache")
                .appointmentTime(LocalDateTime.of(2025, 9, 13, 18, 30))
                .build();
        Appointment updatedAppointment = appointmentService.createNewAppointment(appointment, 4L, 4L);
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
