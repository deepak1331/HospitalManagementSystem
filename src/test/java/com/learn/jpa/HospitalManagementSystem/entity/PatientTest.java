package com.learn.jpa.HospitalManagementSystem.entity;

import com.learn.jpa.HospitalManagementSystem.constant.BloodGroupType;
import com.learn.jpa.HospitalManagementSystem.constant.Gender;
import com.learn.jpa.HospitalManagementSystem.repo.PatientRepository;
import com.learn.jpa.HospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testAddPatient() {
        LocalDate dob = LocalDate.of(1991, 9, 8);
        //Patient patient = new Patient(1L, "Deepak Yadav", dob, "Male",
        //                      "deepakyadav1331@gmail.com", "7777788888");
        Patient patient = Patient.builder()
                .name("Shubham Yadav")
                .birthDate(dob)
                .gender(Gender.Male.toString())
                .email("shubhamyadav123@gmail.com")
                .phoneNo("772343243")
                .bloodGroup(String.valueOf(BloodGroupType.A_POSITIVE))
                .build();

        Patient result = patientRepository.save(patient);
        System.out.printf("Patient Saved: %s", result);
        Assert.notNull(patient, "Not null");
    }

    @Test
    public void testAddAllPatient() {
        //Patient patient = new Patient(1L, "Deepak Yadav", dob, "Male",
        //                      "deepakyadav1331@gmail.com", "7777788888");
        Patient patient = Patient.builder()
                .name("Deepak Yadav")
                .birthDate(LocalDate.of(1988, 6 ,13))
                .gender(Gender.Male.toString())
                .email("deepakyadav1331@gmail.com")
                .phoneNo("7401087950")
                .bloodGroup(BloodGroupType.AB_POSITIVE.getType())
                .build();

        Patient patient1 = Patient.builder()
                .name("Shipra Yadav")
                .birthDate(LocalDate.of(1989, 9 ,3))
                .gender(Gender.Female.name())
                .email("shiprayadav@gmail.com")
                .phoneNo("7776688888")
                .bloodGroup(BloodGroupType.O_NEGATIVE.getType())
                .build();
        
        Patient patient2 = Patient.builder()
                .name("Avyaan Yadav")
                .birthDate(LocalDate.of(2021, 12 ,20))
                .gender(Gender.Male.toString())
                .email("avyaanyadav@gmail.com")
                .phoneNo("7776688123")
                .bloodGroup(BloodGroupType.B_POSITIVE.toString())
                .build();

        List<Patient> result = patientRepository.saveAll(List.of(patient,patient1, patient2));
        System.out.printf("Patient Saved: %s", result);
        Assert.notNull(patient, "Not null");
    }

    @Test
    public void testFindAllPatient() {
//        Pageable pageable = Pageable.ofSize(5);
//        Page<Patient> result2 = repository.findAll(pageable);

        List<Patient> result = patientRepository.findAll();
        System.out.printf("No. of Patient : %d\n", result.size());
        result.forEach(System.out::println);
    }

    @Test
    public void testFindAllPatientId() {
        Long patientId = 3L;
        Patient patient;
        patient = patientService.getPatientById(patientId);

        System.out.printf("Patient with ID: %d Output: %s", patientId, patient);
    }
}
