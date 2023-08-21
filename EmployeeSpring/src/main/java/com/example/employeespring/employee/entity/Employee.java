package com.example.employeespring.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_db")
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private Integer employeeID;
    @Column(nullable = false,length = 150)
    @Length(min = 1,max = 150)
    private String firstName;
    @Column(nullable = false,length = 150)
    @Length(min = 1,max = 150)
    private String lastName;
    @Column(nullable = false,length = 150)
    @Length(min = 1,max = 150)
    private String department;
    @Column(nullable = false,length = 150)
    @Length(min = 4,max = 30)
    private String gender;
    @Column
    private int age;
    @Column
    private long salary;
}
