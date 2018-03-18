package com.example.employeesapi.models;

import javax.persistence.*;

import com.example.employeesapi.dataviews.DataViews;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "POSITIONS")
public class Position implements Serializable {

    @JsonView({DataViews.PositionView.class, DataViews.EmployeeView.class, DataViews.RegionView.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POSITION_ID")
    private Long id;

    @JsonView({DataViews.EmployeeView.class, DataViews.PositionView.class, DataViews.RegionView.class})
    @Column(name = "POSITION")
    private String name;

    @JsonView({DataViews.PositionView.class})
    @OneToMany(
        mappedBy = "position",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Employee> employees = new ArrayList<>();


    public Position(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }
}
