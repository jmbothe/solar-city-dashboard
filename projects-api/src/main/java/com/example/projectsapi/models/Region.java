package com.example.projectsapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
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
    private List<Project> projects;

    public Region(String name, List<Project> employees) {
        this.name = name;
        this.projects = projects;
    }
}