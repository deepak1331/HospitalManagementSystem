package com.learn.jpa.HospitalManagementSystem.repo;

import com.learn.jpa.HospitalManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}