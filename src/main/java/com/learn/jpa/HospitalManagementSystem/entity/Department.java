package com.learn.jpa.HospitalManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String name;

    @OneToOne
    @JsonManagedReference
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable(
            name = "my_dept_doctors",
            joinColumns = @JoinColumn(name = "dept_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    @JsonManagedReference
    private Set<Doctor> doctors = new HashSet<>();

    @CreationTimestamp
    @JsonIgnore
    public LocalDateTime createdOn;
}
