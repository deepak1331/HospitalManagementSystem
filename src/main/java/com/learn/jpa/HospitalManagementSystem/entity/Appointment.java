package com.learn.jpa.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 128)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdOn;

    //Owning Side, since appointment doesn't exist without patient,
    //here appointment owns the relationship
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "patient_id", nullable = false) //patient is required and non nullable
    private Patient patient;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Doctor doctor;
}