package com.example.employeesapi.models;

import javax.persistence.*;

import com.example.employeesapi.dataviews.DataViews;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "EMPLOYEES")
public class Employee implements Serializable {

    @JsonView({DataViews.EmployeeView.class, DataViews.RegionView.class, DataViews.PositionView.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @JsonView({DataViews.EmployeeView.class, DataViews.RegionView.class, DataViews.PositionView.class})
    @Column(name = "FIRST_NAME")
    private String firstName;

    @JsonView({DataViews.EmployeeView.class, DataViews.RegionView.class, DataViews.PositionView.class})
    @Column(name = "LAST_NAME")
    private String lastName;

    @JsonView({DataViews.EmployeeView.class, DataViews.RegionView.class, DataViews.PositionView.class})
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @JsonView({DataViews.EmployeeView.class, DataViews.RegionView.class, DataViews.PositionView.class})
    @Column(name = "EMAIL")
    private String email;

    @JsonView({DataViews.EmployeeView.class, DataViews.RegionView.class, DataViews.PositionView.class})
    @Column(name = "PASSWORD")
    private String password;

    @Column(name="REGION_ID")
    private long regionId;


    @Column(name="POSITION_ID")
    private long positionId;

    @JsonView({DataViews.EmployeeView.class, DataViews.RegionView.class, DataViews.PositionView.class})
    @Column(name = "ASSIGNED_TO")
    private Long assignedTo;

    public Employee(
            String firstName,
            String lastName,
            String phoneNumber,
            String email,
            String password,
            long regionId,
            long positionId,
            Long assignedTo
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.regionId = regionId;
        this.positionId = positionId;
        this.assignedTo = assignedTo;
    }
}
