package com.learn.jpa.HospitalManagementSystem.entity;

import com.learn.jpa.HospitalManagementSystem.constant.BloodGroupType;
import com.learn.jpa.HospitalManagementSystem.constant.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient_tbl",
        uniqueConstraints = {
                //@UniqueConstraint(name = "unique_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_name_dob", columnNames = {"patient_name", "birthDate"})
        },
        indexes = {
                @Index(name = "idx_birthDate", columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name", length = 50, nullable = false)
    private String name;

    private LocalDate birthDate;

//    @Column(length = 6, nullable = false)
//    private String gender;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 15, nullable = false)
    private String phoneNo;

//    @Column(length = 3)
//    private String bloodGroup;

    @Enumerated(EnumType.ORDINAL)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    @ToString.Exclude
    private LocalDateTime createdOn;


    @OneToOne
    @JoinColumn(name = "patient_insurance_id") //Owning Side
    private Insurance insurance;
}
