package com.example.employeesapi.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "REGIONS")
public class Region implements Serializable {

    @JsonView({RegionView.Summary.class, EmployeeView.Summary.class, PositionView.Summary.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGION_ID")
    private Long id;

    @JsonView({EmployeeView.Summary.class, RegionView.Summary.class, PositionView.Summary.class})
    @Column(name = "REGION_NAME")
    private String name;

    @JsonView({RegionView.Summary.class})
    @OneToMany(
        mappedBy = "region",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Employee> employees = new ArrayList<>();

    public Region(String regionName, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }
}