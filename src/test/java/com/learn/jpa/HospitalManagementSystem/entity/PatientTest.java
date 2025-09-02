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
                .gender(Gender.Male)
                .email("shubhamyadav123@gmail.com")
                .phoneNo("772343243")
                .bloodGroup(BloodGroupType.A_POSITIVE)
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
                .birthDate(LocalDate.of(1988, 6, 13))
                .gender(Gender.Male)
                .email("deepakyadav1331@gmail.com")
                .phoneNo("7401087950")
                .bloodGroup(BloodGroupType.AB_POSITIVE)
                .build();

        Patient patient1 = Patient.builder()
                .name("Shipra Yadav")
                .birthDate(LocalDate.of(1989, 9, 3))
                .gender(Gender.Female)
                .email("shiprayadav@gmail.com")
                .phoneNo("7776688888")
                .bloodGroup(BloodGroupType.O_NEGATIVE)
                .build();

        Patient patient2 = Patient.builder()
                .name("Avyaan Yadav")
                .birthDate(LocalDate.of(2021, 12, 20))
                .gender(Gender.Male)
                .email("avyaanyadav@gmail.com")
                .phoneNo("7776688123")
                .bloodGroup(BloodGroupType.B_POSITIVE)
                .build();

        List<Patient> result = patientRepository.saveAll(List.of(patient, patient1, patient2));
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

    @Test
    public void testFindByName() {
        String patientName = "Deepak Yadav";
        Patient patient;
        patient = patientService.findByName(patientName);
        System.out.printf("PatientName: %s Output: %s", patientName, patient);
    }

    @Test
    public void testFindByGender() {
        Gender gender = Gender.Male;
        List<Patient> result = patientRepository.findByGender(gender);
        System.out.printf("For Gender: %s No. of matching Patients : %d \n", gender, result.size());
        result.forEach(System.out::println);
    }
}
