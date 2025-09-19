package com.learn.jpa.HospitalManagementSystem.repo;

import com.learn.jpa.HospitalManagementSystem.entity.type.BloodGroupType;
import com.learn.jpa.HospitalManagementSystem.entity.type.Gender;
import com.learn.jpa.HospitalManagementSystem.dto.BloodGroupCountResponseDTO;
import com.learn.jpa.HospitalManagementSystem.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String patientName);

    Patient findByBirthDate(LocalDate dob);

    Patient findByBirthDateOrEmail(LocalDate dob, String email);

    Optional<Patient> findByBirthDateAndEmail(LocalDate dob, String email);

    List<Patient> findByGender(Gender type);

    List<Patient> findByEmailOrBloodGroup(String email, BloodGroupType type);

    List<Patient> findByNameNotNull();

    List<Patient> findByNameIsNull();

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    /*********** JPQL Queries *************/
    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p FROM Patient p where p.phoneNo = :phoneNo")
    List<Patient> findByMobileNumber(@Param("phoneNo") String phoneNo);

    @Query("SELECT p.bloodGroup, count(*) as count FROM Patient p group by p.bloodGroup")
    //List<Object[]> findCountByBloodGroupCount(@Param("bloodGroup") String bloodGroup);
    List<Object[]> findCountByBloodGroup();

    @Query("SELECT new com.learn.jpa.HospitalManagementSystem.dto.BloodGroupCountResponseDTO(p.bloodGroup, count(*))" +
            " FROM Patient p group by p.bloodGroup")
    List<BloodGroupCountResponseDTO> findCountByBloodGroup2();

    //@Query("SELECT p FROM Patient p LEFT JOIN p.appointments a LEFT JOIN FETCH a.doctor")
    @Query("SELECT p FROM Patient p LEFT JOIN p.appointments")
    List<Patient> findAllPatientWithAppointments();

    //native Query
    @Query(value = "SELECT * FROM patient_tbl p where p.id = :id", nativeQuery = true)
    Optional<Patient> findPatientById(@Param("id") Long id);

    @Query(value = "SELECT * FROM patient_tbl p where p.gender = :gender", nativeQuery = true)
    List<Patient> findPatientByGender(@Param("gender") String gender);


    @Transactional
    @Modifying
    @Query("Update Patient p SET p.name = :name where p.id = :id")
    int updateNameById(@Param("name") String name,@Param("id") Long id);


    //******** Pagination ********//
    @Query(value = "SELECT * FROM patient_tbl", nativeQuery = true)
    List<Patient> findPatientByPage(Pageable pageable);

    @Query(value = "SELECT * FROM patient_tbl", nativeQuery = true)
    Page<Patient> findPatientByPageable(Pageable pageable);


}
