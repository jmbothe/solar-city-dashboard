package com.example.employeesapi.models;

import javax.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "EMPLOYEES")
public class Employee implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PASSWORD")
    private String password;

    @ManyToOne
    @JoinColumn(name = "REGION_ID", referencedColumnName="REGION_ID")
    private Region region;
    
    @ManyToOne
    @JoinColumn(name = "POSITION_ID", referencedColumnName = "POSITION_ID")
    private Position position;

    @Column(name = "ASSIGNED_TO")
    private Long assignedTo;

    public Employee(
            String firstName,
            String lastName,
            String phoneNumber,
            String email,
            String password,
            Region region,
            Position position,
            Long assignedTo
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.region = region;
        this.position = position;
        this.assignedTo = assignedTo;
    }
}