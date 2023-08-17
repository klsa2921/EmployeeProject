package com.example.employeespring.employee.service;

import com.example.employeespring.employee.entity.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {

    Employee addEmployee(Map<String,Object> employeeDetails);
    List<Map<String,Object>> getAllEmployees();
    Employee updateEmployeeByEmpId(Integer employeeID,Map<String,Object> employeeDetails);
    void deleteEmployeeByEmpId(Integer employeeID);
}
