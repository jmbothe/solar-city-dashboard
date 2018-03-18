package com.example.employeesapi.controllers;

import com.example.employeesapi.models.Employee;
import com.example.employeesapi.models.EmployeeView;
import com.example.employeesapi.models.PositionView;
import com.example.employeesapi.models.RegionView;
import com.example.employeesapi.repositories.EmployeeRepository;
import com.example.employeesapi.repositories.PositionRepository;
import com.example.employeesapi.repositories.RegionRepository;
import com.fasterxml.jackson.annotation.JsonView;
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

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private PositionRepository positionRepository;

    @JsonView(EmployeeView.Summary.class)
    @GetMapping("/all")
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    // TODO: is array the right data structure for function parameter??

    @JsonView(EmployeeView.Summary.class)
    @GetMapping("/id/{ids}")
    public Iterable<Optional> findEmployeesById(@PathVariable Long[] ids) {
        List<Optional> responseBody = new ArrayList<>();

        for (Long id : ids) {
            responseBody.add(employeeRepository.findById(id));
        }
        return responseBody;
    }

    // TODO: is array the right data structure for function parameter??

    @JsonView(EmployeeView.Summary.class)
    @GetMapping("/email/{emails}")
    public Iterable<Employee> findEmployeesByEmail(@PathVariable String[] emails) {
        List<Employee> responseBody = new ArrayList<>();

        for (String email : emails) {
            responseBody.add(employeeRepository.findByEmailContaining(email));
        }
        return responseBody;
    }

    @JsonView(RegionView.Summary.class)
    @GetMapping("/region/{region}")
    public Optional findEmployeesByRegion(@PathVariable Long region) {
            return regionRepository.findById(region);
    }

    @JsonView(PositionView.Summary.class)
    @GetMapping("/position/{position}")
    public Optional findEmployeesByPosition(@PathVariable Long position) {
        return positionRepository.findById(position);
    }
}
