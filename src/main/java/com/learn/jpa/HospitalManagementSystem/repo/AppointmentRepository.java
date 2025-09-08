package com.learn.jpa.HospitalManagementSystem.repo;

import com.learn.jpa.HospitalManagementSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}