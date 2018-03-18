package com.example.employeesapi.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "EMPLOYEES")
public class Employee implements Serializable {

    @JsonView({EmployeeView.Summary.class, RegionView.Summary.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @JsonView({EmployeeView.Summary.class, RegionView.Summary.class})
    @Column(name = "FIRST_NAME")
    private String firstName;

    @JsonView({EmployeeView.Summary.class, RegionView.Summary.class})
    @Column(name = "LAST_NAME")
    private String lastName;

    @JsonView({EmployeeView.Summary.class, RegionView.Summary.class})
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @JsonView({EmployeeView.Summary.class, RegionView.Summary.class})
    @Column(name = "EMAIL")
    private String email;

    @JsonView({EmployeeView.Summary.class, RegionView.Summary.class})
    @Column(name = "PASSWORD")
    private String password;

    @JsonView({EmployeeView.Summary.class, PositionView.Summary.class})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @JsonView({EmployeeView.Summary.class, RegionView.Summary.class})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSITION_ID")
    private Position position;

    public Employee(
            String firstName,
            String lastName,
            String phoneNumber,
            String email,
            String password,
            Region region,
            Position position
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.region = region;
        this.position = position;
    }
}
