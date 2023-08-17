package com.example.employeespring.employee.repository;

import com.example.employeespring.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findAll();
    Employee findByEmployeeID(Integer id);

    void deleteByEmployeeID(Integer employeeID);
}
