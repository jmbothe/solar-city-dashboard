package com.example.employeesapi.controllers;

import com.example.employeesapi.models.Employee;
import com.example.employeesapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeesController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/id/{ids}")
    public Iterable<Optional> findEmployeesById(@PathVariable Long[] ids) {
        List<Optional> response = new ArrayList<>();

        for (Long id : ids) {
            response.add(employeeRepository.findById(id));
        }
        return response;
    }

    @GetMapping("/email/{emails}")
    public Iterable<Employee> findEmployeesByEmail(@PathVariable String[] emails) {
        List<Employee> response = new ArrayList<>();

        for (String email : emails) {
            response.add(employeeRepository.findByEmailContaining(email));
        }
        return response;
    }

    @GetMapping("/region/{region}")
    public Iterable<Employee> findEmployeesByRegion(@PathVariable Long[] regions) {
        List<Employee> response = new ArrayList<>();

        for (Long region : regions) {
            response.add(employeeRepository.findByRegionContaining(region));
        }
        return response;
    }
}
