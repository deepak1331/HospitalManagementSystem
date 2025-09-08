package com.learn.jpa.HospitalManagementSystem.repo;

import com.learn.jpa.HospitalManagementSystem.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}