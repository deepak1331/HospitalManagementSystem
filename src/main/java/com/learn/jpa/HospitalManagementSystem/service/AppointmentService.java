package com.learn.jpa.HospitalManagementSystem.service;

import com.learn.jpa.HospitalManagementSystem.entity.Appointment;
import com.learn.jpa.HospitalManagementSystem.entity.Doctor;
import com.learn.jpa.HospitalManagementSystem.entity.Patient;
import com.learn.jpa.HospitalManagementSystem.repo.AppointmentRepository;
import com.learn.jpa.HospitalManagementSystem.repo.DoctorRepository;
import com.learn.jpa.HospitalManagementSystem.repo.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {
        if (appointment.getId() != null)
            throw new IllegalArgumentException("Appointment shouldn't have ID");

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }
}
