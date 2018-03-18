package com.example.projectsapi.models;

import com.example.projectsapi.dataviews.DataViews;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "REGIONS")
public class Region implements Serializable {

    @JsonView({DataViews.RegionView.class, DataViews.ProjectView.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGION_ID")
    private Long id;

    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    @Column(name = "REGION_NAME")
    private String name;

    @JsonView({DataViews.RegionView.class})
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