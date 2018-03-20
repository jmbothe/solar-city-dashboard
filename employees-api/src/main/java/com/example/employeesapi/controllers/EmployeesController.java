package com.example.employeesapi.controllers;

import com.example.employeesapi.models.Employee;
import com.example.employeesapi.repositories.EmployeeRepository;
import com.example.employeesapi.repositories.PositionRepository;
import com.example.employeesapi.repositories.RegionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.stream.Collectors;

import java.util.Optional;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeesController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/all")
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
    
    @GetMapping("/by-id/{ids}")
    public Optional[] findEmployeesById(@PathVariable Long[] ids) {
        Optional[] responseBody = new Optional[ids.length];

        int i = 0;
        for (Long id : ids) {
            responseBody[i] = employeeRepository.findById(id);
            i++;
        }
        return responseBody;
    }
    
    @GetMapping("/by-email/{emails}")
    public Employee[] findEmployeesByEmail(@PathVariable String[] emails) {
        Employee[] responseBody = new Employee[emails.length];

        int i = 0;
        for (String email : emails) {
            responseBody[i] = employeeRepository.findByEmailContaining(email);
            i++;
        }
        return responseBody;
    }

    
    @GetMapping("/by-region/{region}")
    public Iterable<Employee> findEmployeesByRegion(@PathVariable Long region) {
        return StreamSupport
            .stream(employeeRepository.findAll().spliterator(), false)
            .filter(employee -> employee.getRegion().getId() == region)
            .collect(Collectors.toList());
    }
    
    @GetMapping("/by-position/{position}")
    public Iterable<Employee> findEmployeesByPosition(@PathVariable Long position) {
        return StreamSupport
            .stream(employeeRepository.findAll().spliterator(), false)
            .filter(employee -> employee.getPosition().getId() == position)
            .collect(Collectors.toList());
    }

    @PatchMapping("/update-contact/{id}")
    public HttpStatus updateEmployeeContact(@PathVariable long id, @RequestBody Employee employeeRequest) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setPhoneNumber(employeeRequest.getPhoneNumber());
        employee.setEmail(employeeRequest.getEmail());
        employeeRepository.save(employee);
        return HttpStatus.OK;
    }
    
    @PatchMapping("/assign/{id}")
    public HttpStatus assignEmployee(@PathVariable long id,  @RequestBody Employee employeeRequest) {
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
