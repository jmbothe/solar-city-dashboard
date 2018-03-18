package com.example.employeesapi.repositories;

import com.example.employeesapi.models.Employee;
import com.example.employeesapi.models.RegionEmployee;
import org.springframework.data.repository.CrudRepository;

public interface RegionEmployeeRepository extends CrudRepository <RegionEmployee, Long> {
    RegionEmployee findByEmailContaining(String email);

}
