package com.learn.jpa.HospitalManagementSystem.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String specialization;

    @Column(length = 30, nullable = false, unique = true)
    private String email;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @OneToMany(mappedBy = "doctor")
    //@ToString.Exclude
    @JsonBackReference
    private List<Appointment> appointments = new ArrayList<>();

    @ManyToMany(mappedBy = "doctors")
    @JsonBackReference
    private Set<Department> departments = new HashSet<>();
}
