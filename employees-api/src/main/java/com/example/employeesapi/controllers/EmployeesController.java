package com.example.employeesapi.controllers;

import com.example.employeesapi.dataviews.DataViews;
import com.example.employeesapi.models.Employee;
import com.example.employeesapi.models.RegionEmployee;
import com.example.employeesapi.repositories.EmployeeRepository;
import com.example.employeesapi.repositories.PositionRepository;
import com.example.employeesapi.repositories.RegionEmployeeRepository;
import com.example.employeesapi.repositories.RegionRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private RegionEmployeeRepository regionEmployeeRepository;

    @JsonView(DataViews.EmployeeView.class)
    @GetMapping("/all")
    public Iterable<RegionEmployee> findAllEmployees() {
        return regionEmployeeRepository.findAll();
    }

    // TODO: is array the right data structure for function parameter??
    // ANSWER: yes, because size is declared in advance, so insertion is fast

    @JsonView(DataViews.EmployeeView.class)
    @GetMapping("/by-id/{ids}")
    public Iterable<Optional> findEmployeesById(@PathVariable Long[] ids) {
        List<Optional> responseBody = new ArrayList<>();

        for (Long id : ids) {
            responseBody.add(regionEmployeeRepository.findById(id));
        }
        return responseBody;
    }

    // TODO: is array the right data structure for function parameter??
    // ANSWER: yes, because size is declared in advance, so insertion is fast

    @JsonView(DataViews.EmployeeView.class)
    @GetMapping("/by-email/{emails}")
    public Iterable<RegionEmployee> findEmployeesByEmail(@PathVariable String[] emails) {
        List<RegionEmployee> responseBody = new ArrayList<>();

        for (String email : emails) {
            responseBody.add(regionEmployeeRepository.findByEmailContaining(email));
        }
        return responseBody;
    }

    @JsonView(DataViews.RegionView.class)
    @GetMapping("/by-region/{region}")
    public Optional findEmployeesByRegion(@PathVariable Long region) {
            return regionRepository.findById(region);
    }

    @JsonView(DataViews.PositionView.class)
    @GetMapping("/by-position/{position}")
    public Optional findEmployeesByPosition(@PathVariable Long position) {
        return positionRepository.findById(position);
    }

    @PatchMapping("/update-contact/{id}")
    public HttpStatus updateEmployeeContact(@PathVariable long id, @RequestBody Employee employeeRequest) {
        Employee employee = employeeRepository.findById(id).get();

        employee.setPhoneNumber(employeeRequest.getPhoneNumber());
        employee.setEmail(employeeRequest.getEmail());

        employeeRepository.save(employee);
        return HttpStatus.OK;
    }

    @PatchMapping("/unassign/{id}")
    public HttpStatus unassignEmployee(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).get();

        employee.setAssignedTo(null);

        employeeRepository.save(employee);
        return HttpStatus.OK;
    }

    @PatchMapping("/assign/{id}")
    public HttpStatus assignEmployee(@PathVariable long id, @RequestBody Employee employeeRequest) {
        Employee employee = employeeRepository.findById(id).get();

        employee.setAssignedTo(employeeRequest.getAssignedTo());
        employeeRepository.save(employee);
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteUserById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/create")
    public Employee createNewEmployee(@RequestBody Employee newEmployee) {

        return employeeRepository.save(newEmployee);
    }
}
