package com.example.employeespring.employee.controller;

import com.example.employeespring.employee.entity.Employee;
import com.example.employeespring.employee.repository.EmployeeRepository;
import com.example.employeespring.employee.service.IEmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/authentication/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Map<String,Object> employeeDetails) throws Throwable {
        Employee employee=employeeService.addEmployee(employeeDetails);
        if (employee!=null) return ResponseEntity.ok("Employee added successfully....");
        else throw new Exception().fillInStackTrace();
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Map<String,Object>>> getAllEmployees(){
        List<Map<String,Object>> employeeDetails= employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDetails);
    }

    @PostMapping("/updateEmployee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody Map<String,Object> employeeDetails){
        Employee employee=employeeService.updateEmployeeByEmpId(id,employeeDetails);
        if (employee != null) return ResponseEntity.ok("Employee updated successfully");
        else throw new EntityNotFoundException("Employee details not found");
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeID){
        employeeService.deleteEmployeeByEmpId(employeeID);
        return ResponseEntity.ok("deleted employee successfully");
    }
}
