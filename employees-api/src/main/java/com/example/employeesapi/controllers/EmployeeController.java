package com.example.employeesapi.controllers;

import com.example.employeesapi.models.Employee;
import com.example.employeesapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
