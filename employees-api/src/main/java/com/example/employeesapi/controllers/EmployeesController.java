package com.example.employeesapi.controllers;

import com.example.employeesapi.dataviews.DataViews;
import com.example.employeesapi.models.Employee;
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

    @JsonView(DataViews.EmployeeView.class)
    @GetMapping("/all")
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    // TODO: is array the right data structure for function parameter??
    // ANSWER: yes, because size is declared in advance, so insertion is fast

    @JsonView(DataViews.EmployeeView.class)
    @GetMapping("/id/{ids}")
    public Iterable<Optional> findEmployeesById(@PathVariable Long[] ids) {
        List<Optional> responseBody = new ArrayList<>();

        for (Long id : ids) {
            responseBody.add(employeeRepository.findById(id));
        }
        return responseBody;
    }

    // TODO: is array the right data structure for function parameter??
    // ANSWER: yes, because size is declared in advance, so insertion is fast

    @JsonView(DataViews.EmployeeView.class)
    @GetMapping("/email/{emails}")
    public Iterable<Employee> findEmployeesByEmail(@PathVariable String[] emails) {
        List<Employee> responseBody = new ArrayList<>();

        for (String email : emails) {
            responseBody.add(employeeRepository.findByEmailContaining(email));
        }
        return responseBody;
    }

    @JsonView(DataViews.RegionView.class)
    @GetMapping("/region/{region}")
    public Optional findEmployeesByRegion(@PathVariable Long region) {
            return regionRepository.findById(region);
    }

    @JsonView(DataViews.PositionView.class)
    @GetMapping("/position/{position}")
    public Optional findEmployeesByPosition(@PathVariable Long position) {
        return positionRepository.findById(position);
    }
}
