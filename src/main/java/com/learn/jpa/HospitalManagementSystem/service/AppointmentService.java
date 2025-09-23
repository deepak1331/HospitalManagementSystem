package com.learn.jpa.HospitalManagementSystem.service;

import com.learn.jpa.HospitalManagementSystem.dto.AppointmentResponseDto;
import com.learn.jpa.HospitalManagementSystem.dto.CreateAppointmentRequestDto;
import com.learn.jpa.HospitalManagementSystem.entity.Appointment;
import com.learn.jpa.HospitalManagementSystem.entity.Doctor;
import com.learn.jpa.HospitalManagementSystem.entity.Patient;
import com.learn.jpa.HospitalManagementSystem.repo.AppointmentRepository;
import com.learn.jpa.HospitalManagementSystem.repo.DoctorRepository;
import com.learn.jpa.HospitalManagementSystem.repo.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentResponseDto createNewAppointment(CreateAppointmentRequestDto createAppointmentRequestDto) {
/*        if (appointment.getId() != null)
            throw new IllegalArgumentException("Appointment shouldn't have ID");*/

        Patient patient = patientRepository.findById(createAppointmentRequestDto.getPatientId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + createAppointmentRequestDto.getPatientId()));

        Doctor doctor = doctorRepository.findById(createAppointmentRequestDto.getDoctorId())
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + createAppointmentRequestDto.getDoctorId()));

        Appointment appointment = Appointment.builder()
                .reason(createAppointmentRequestDto.getReason())
                .appointmentTime(createAppointmentRequestDto.getAppointmentTime())
                .build();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);

        return modelMapper.map(appointmentRepository.save(appointment), AppointmentResponseDto.class);
    }

    @Transactional
    public Appointment reassignAppointment(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        appointment.setDoctor(doctor); //this will call for automatic update, since appointment got dirty
        doctor.getAppointments().add(appointment); // for bidirectional mapping
        return appointment;
    }

    public List<AppointmentResponseDto> getAllAppointmentsOfDoctor(Long doctorId) {

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        return doctor.getAppointments().stream()
                .map(appointment ->
                        modelMapper.map(appointment, AppointmentResponseDto.class)).toList();
    }
}
