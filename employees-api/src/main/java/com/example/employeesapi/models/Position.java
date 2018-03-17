package com.example.employeesapi.models;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "POSITIONS")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POSITION_ID")
    private Long id;

    @Column(name = "POSITION")
    private String name;

    public Position(String name) {
        this.name = name;
    }
}
