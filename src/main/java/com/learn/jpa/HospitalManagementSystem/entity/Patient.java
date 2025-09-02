package com.learn.jpa.HospitalManagementSystem.entity;

import com.learn.jpa.HospitalManagementSystem.constant.BloodGroupType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "patient_tbl",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_email", columnNames = {"email"}),
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

    @Column(length = 6, nullable = false)
    private String gender;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String phoneNo;

    private String bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdOn;
}
