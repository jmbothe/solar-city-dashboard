package com.example.employeesapi.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class RegionEmployee implements Serializable {
    private Long employeeId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String password;

    private Long regionId;

    private String regionName;

    private Long positionId;

    private String positionName;

    public RegionEmployee(Employee employee) {
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.phoneNumber = employee.getPhoneNumber();
        this.email = employee.getEmail();
        this.password = employee.getPassword();
        this.regionId = employee.getRegion().getId();
        this.regionName = employee.getRegion().getName();
        this.positionId = employee.getPosition().getId();
        this.positionName = employee.getPosition().getName();
    }
}
