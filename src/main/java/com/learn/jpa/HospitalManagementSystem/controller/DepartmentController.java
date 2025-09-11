package com.learn.jpa.HospitalManagementSystem.controller;

import com.learn.jpa.HospitalManagementSystem.entity.Department;
import com.learn.jpa.HospitalManagementSystem.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment(){
        return ResponseEntity.ok(departmentService.fetchAllDepartments());
    }
}
