package com.example.employeesapi.models;

import javax.persistence.*;

import com.example.employeesapi.dataviews.DataViews;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "REGIONS")
public class Region implements Serializable {

    @JsonView({DataViews.RegionView.class, DataViews.EmployeeView.class, DataViews.PositionView.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGION_ID")
    private Long id;

    @JsonView({DataViews.EmployeeView.class, DataViews.RegionView.class, DataViews.PositionView.class})
    @Column(name = "REGION_NAME")
    private String name;

    @JsonView({DataViews.RegionView.class})
    @OneToMany(
        mappedBy = "region",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<RegionEmployee> employees;

    public Region(String name, List<RegionEmployee> employees) {
        this.name = name;
        this.employees = employees;
    }
}