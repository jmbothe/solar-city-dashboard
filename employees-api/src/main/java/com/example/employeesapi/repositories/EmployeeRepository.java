package com.example.employeesapi.repositories;

import com.example.employeesapi.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository <Employee, Long> {
    Employee findByEmailContaining(String email);
}
