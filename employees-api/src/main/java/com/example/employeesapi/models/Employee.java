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

    @JsonView({DataViews.EmployeeView.class, DataViews.PositionView.class})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @JsonView({DataViews.EmployeeView.class, DataViews.RegionView.class})
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
