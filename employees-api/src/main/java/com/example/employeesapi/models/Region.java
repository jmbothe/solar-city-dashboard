package com.example.employeesapi.models;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "REGIONS")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "REGION_NAME")
    private String regionName;

    public Region(String firstName) {
        this.regionName = regionName;
    }
}
