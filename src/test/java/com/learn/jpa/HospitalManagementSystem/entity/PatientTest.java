package com.learn.jpa.HospitalManagementSystem.entity;

import com.learn.jpa.HospitalManagementSystem.repo.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository repository;

    @Test
    public void testAddPatient() {
        LocalDate dob = LocalDate.of(1988, 5, 13);
        //Patient patient = new Patient(1L, "Deepak Yadav", dob, "Male",
        //                      "deepakyadav1331@gmail.com", "7777788888");
        Patient patient = Patient.builder()
                .name("Deepak Yadav")
                .birthDate(dob)
                .gender("Male")
                .email("deepakyadav1331@gmail.com")
                .phoneNo("7777788888").build();

        Patient result = repository.save(patient);
        System.out.printf("Patient Saved: %s", result);
        Assert.notNull(patient, "Not null");
    }

    @Test
    public void testFindAllPatient() {
//        Pageable pageable = Pageable.ofSize(5);
//        Page<Patient> result2 = repository.findAll(pageable);

        List<Patient> result = repository.findAll();
        System.out.printf("No. of Patient : %s", result.size());
        result.forEach(System.out::println);
    }
}
