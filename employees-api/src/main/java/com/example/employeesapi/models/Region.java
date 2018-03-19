package com.example.employeesapi.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "REGIONS")
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGION_ID")
    private Long id;

    @Column(name = "REGION_NAME")
    private String name;

    @JsonIgnore
    @OneToMany(
        mappedBy = "region",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Employee> employees;

    public Region(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }
}