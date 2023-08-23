package com.example.employeespring.employee.service;

import com.example.employeespring.employee.entity.Employee;
import com.example.employeespring.employee.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Map<String,Object> employeeDetails) {
        Employee employee=new Employee();
        employeeDetails.forEach((key,value)-> {
            System.out.println(key+"-----"+value);
        });
        employee.setId((Integer) employeeDetails.get("id"));
        System.out.println(employee.getId());
        System.out.println(employeeDetails.get("employeeId")+"---key");
        employee.setEmployeeID((Integer) employeeDetails.get("employeeId"));
        System.out.println(employee.getEmployeeID());
        employee.setFirstName((String) employeeDetails.get("firstName"));
        employee.setLastName((String) employeeDetails.get("lastName"));
        employee.setDepartment((String) employeeDetails.get("department"));
        employee.setGender((String) employeeDetails.get("gender"));
        employee.setAge((int) employeeDetails.get("age"));
        employee.setSalary((Integer) employeeDetails.get("salary") );
        System.out.println(employee.getEmployeeID()+"---------------------------------------------------------------------------"+employee.getFirstName());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Map<String, Object>> getAllEmployees() {
        List<Map<String,Object>> employeeDetails= new ArrayList<>();
        List<Employee> employeeData=employeeRepository.findAll();
        employeeData.forEach(emp->{
            Map<String,Object> employeeMap=new HashMap<>();
            employeeMap.put("employeeId",emp.getEmployeeID());
            employeeMap.put("firstName",emp.getFirstName());
            employeeMap.put("lastName",emp.getLastName());
            employeeMap.put("department",emp.getDepartment());
            employeeMap.put("gender",emp.getGender());
            employeeMap.put("age",emp.getAge());
            employeeDetails.add(employeeMap);
        });
        return employeeDetails;
    }

    @Override
    public Employee updateEmployeeByEmpId(Integer employeeID,Map<String,Object> employeeDetails) {
        Employee existingEmployee=employeeRepository.findByEmployeeID(employeeID);
        if (existingEmployee!=null){
            Employee updatedEmployee=new Employee();
            updatedEmployee.setEmployeeID((Integer) employeeDetails.get("employeeID"));
            updatedEmployee.setFirstName((String) employeeDetails.get("firstName"));
            updatedEmployee.setLastName((String) employeeDetails.get("lastName"));
            updatedEmployee.setDepartment((String) employeeDetails.get("department"));
            updatedEmployee.setGender((String) employeeDetails.get("gender"));
            updatedEmployee.setAge((Integer) employeeDetails.get("age"));
            return employeeRepository.save(updatedEmployee);
        }else {
            throw new EntityNotFoundException("Employee details not found");
        }
    }

    @Override
    public void deleteEmployeeByEmpId(Integer employeeID) {
        employeeRepository.deleteByEmployeeID(employeeID);
    }

    @Override
    public List<Employee> addListOfEmployees(List<Map<String, Object>> employeeList) {
        List<Employee> employees=new ArrayList<>();
        employeeList.forEach(map->{
            employees.add(addEmployee(map));
        });
        return employees;
    }
}
