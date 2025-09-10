package com.learn.jpa.HospitalManagementSystem;

import com.learn.jpa.HospitalManagementSystem.constant.BloodGroupType;
import com.learn.jpa.HospitalManagementSystem.constant.Gender;
import com.learn.jpa.HospitalManagementSystem.entity.Patient;
import com.learn.jpa.HospitalManagementSystem.repo.PatientRepository;
import com.learn.jpa.HospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
                .name("Shikha Yadav")
                .birthDate(dob)
                .gender(Gender.Female)
                .email("shikhayadav123@gmail.com")
                .phoneNo("792343243")
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
        List<Patient> result = patientRepository.findAllPatientWithAppointments();
                //patientRepository.findAll();
        System.out.printf("No. of Patient : %d\n", result.size());
        result.forEach(System.out::println);
    }

    @Test
    public void testFindByPatientId() {
        Long patientId = 3L;
        Patient patient;
        patient = patientService.findById(patientId);

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
        Gender gender = Gender.Female;
        List<Patient> result = patientRepository.findByGender(gender);
        System.out.printf("For Gender: %s No. of matching Patients : %d \n", gender, result.size());
        result.forEach(System.out::println);
    }

    @Test
    public void testFindByEmailOrBloodGroup() {
        BloodGroupType bloodGroup = BloodGroupType.O_NEGATIVE;
        String email = "deepakyadav1331@gmail.com";
        List<Patient> result = patientRepository.findByEmailOrBloodGroup(email, bloodGroup);
        System.out.printf("For BloodGroup: %s OR Email: %s No. of matching Patients : %d \n", bloodGroup, email, result.size());
        result.forEach(System.out::println);
    }

    @Test
    public void testFindByBirthDateBetween() {
        LocalDate startDate = LocalDate.of(1990, 1, 1);
        LocalDate endDate = LocalDate.of(1994, 12, 31);
        List<Patient> result = patientRepository.findByBirthDateBetween(startDate, endDate);
        System.out.printf("For Birthdate Between: %s and  %s \nNo. of matching Patients : %d \n", startDate, endDate, result.size());
        result.forEach(System.out::println);
    }

    @Test
    public void testFindByMobileNumber() {
        String mobileNumber = "772343243";
        List<Patient> result = patientRepository.findByMobileNumber(mobileNumber);
        System.out.printf("For MobileNumber: %s \nNo. of matching Patients : %d \n", mobileNumber, result.size());
        result.forEach(System.out::println);
    }


    @Test
    public void testFindByBloodGroup() {
        BloodGroupType bloodGroupType = BloodGroupType.AB_POSITIVE;
        List<Patient> result = patientRepository.findByBloodGroup(bloodGroupType);
        System.out.printf("For BloodGroupType: %s \nNo. of matching Patients : %d \n", bloodGroupType, result.size());
        result.forEach(System.out::println);
    }

    @Test
    public void testFindCountByBloodGroup() {
        List<Object[]> result = patientRepository.findCountByBloodGroup();
        result.forEach(s -> {
            System.out.println(s[0] + " : " + s[1]);
        });
    }

    @Test
    public void testFindCountByBloodGroup2() {
        patientRepository.findCountByBloodGroup2().forEach(System.out::println);
    }

    @Test
    public void testFindPatientById() {
        System.out.println("Find by Id = 3. Result : " + patientRepository.findPatientById(3L));
    }

    @Test
    public void testUpdateNameById() {
        System.out.println("Update Name where ID: 5. Column Updated Count: " + patientRepository.updateNameById("Gunjan", 8L));
    }

    @Test
    public void testFindPatientByGender() {
        patientRepository.findPatientByGender(Gender.Female.toString()).forEach(System.out::println);
    }

    @Test
    public void testFindPatientByPage() {
        patientRepository.findPatientByPage(PageRequest.of(0, 2))
                .forEach(System.out::println);
    }

    /**
     * Pageable sortedByName = PageRequest.of(0, 3, Sort.by("name"));
     *
     * Pageable sortedByPriceDesc =  PageRequest.of(0, 3, Sort.by("price").descending());
     *
     * Pageable sortedByPriceDescNameAsc =
     * PageRequest.of(0, 5, Sort.by("price").descending().and(Sort.by("name")));
     */
    @Test
    public void testFindPatientByPageable() {
        Page<Patient> response = patientRepository.findPatientByPageable(PageRequest.of(0,3,
                Sort.by("birth_date").descending()));

        System.out.println(response);
        response.forEach(System.out::println);
    }
}
