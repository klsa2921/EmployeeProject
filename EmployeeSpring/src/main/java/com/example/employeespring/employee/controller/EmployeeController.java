package com.example.employeespring.employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(){
        return ResponseEntity.ok("Employee added with authentication");
    }
}
