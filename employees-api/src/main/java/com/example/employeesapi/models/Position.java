package com.example.employeesapi.models;

import javax.persistence.*;

import com.example.employeesapi.dataviews.DataViews;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "POSITIONS")
public class Position implements Serializable {

    @JsonView({DataViews.Concise.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POSITION_ID")
    private Long id;

    @JsonView({DataViews.Concise.class})
    @Column(name = "POSITION")
    private String name;

    @OneToMany(
        mappedBy = "position",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Employee> employees;

    public Position(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }
}
