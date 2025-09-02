package com.learn.jpa.HospitalManagementSystem.repo;

import com.learn.jpa.HospitalManagementSystem.constant.Gender;
import com.learn.jpa.HospitalManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String patientName);
    Patient findByBirthDate(LocalDate dob);
    Patient findByBirthDateOrEmail(LocalDate dob, String email);
    List<Patient> findByGender(Gender type);
}
