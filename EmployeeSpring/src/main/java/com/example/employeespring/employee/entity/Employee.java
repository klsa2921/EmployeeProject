package com.example.employeespring.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_db")
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    private long employeeID;
    private String firstName;
    private String lastName;
    private String department;
    private String gender;
    private String age;
}
