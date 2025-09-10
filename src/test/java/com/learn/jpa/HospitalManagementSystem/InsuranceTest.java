package com.learn.jpa.HospitalManagementSystem;

import com.learn.jpa.HospitalManagementSystem.entity.Insurance;
import com.learn.jpa.HospitalManagementSystem.entity.Patient;
import com.learn.jpa.HospitalManagementSystem.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testAttachInsuranceToPatient(){

        Insurance insurance = Insurance.builder()
                .provider("TATA AIG")
                .policyNumber("TATA2025_12346")
                .validUntil(LocalDate.now().plusYears(1))
                .build();

        Patient patient = insuranceService.attachInsuranceToPatient(insurance, 4L);
        System.out.println(patient);

        //Assert.notNull(patient,"Value not null");
    }


}