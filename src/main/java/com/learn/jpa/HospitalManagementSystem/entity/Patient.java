package com.learn.jpa.HospitalManagementSystem.entity;

import com.learn.jpa.HospitalManagementSystem.constant.BloodGroupType;
import com.learn.jpa.HospitalManagementSystem.constant.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@Table(name = "patient_tbl",
        uniqueConstraints = {
                //@UniqueConstraint(name = "unique_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_name_dob", columnNames = {"patient_name", "birthDate"})
        },
        indexes = {
                @Index(name = "idx_birthDate", columnList = "birthDate")
        }
)
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name", length = 50, nullable = false)
    private String name;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 15, nullable = false)
    private String phoneNo;

    @Enumerated(EnumType.ORDINAL)
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "patient_insurance_id") //Owning Side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdOn;

//    @Column(length = 6, nullable = false)
//    private String gender;
//    @Column(length = 3)
//    private String bloodGroup;
}