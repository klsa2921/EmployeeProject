package com.example.employeespring.employee.controller;

import com.example.employeespring.employee.entity.Employee;

import com.example.employeespring.employee.service.IEmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;


    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Map<String,Object> employeeDetails) throws Throwable {
        System.out.println("--------------------------------------------------------------------------------------------------");
        employeeDetails.forEach((key,value)-> {
            System.out.println(value);
        });
        Employee employee=employeeService.addEmployee(employeeDetails);
        System.out.println(employee.getEmployeeID()+"----------------------------------------------------"+employee.getFirstName());
        URI employeeURI=URI.create("/employees/"+ employee.getId());
        return  ResponseEntity.created(employeeURI).body(employee);
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