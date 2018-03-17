package com.example.employeesapi.models;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "POSITION")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "POSITION")
    private String position;

    public Position(String position) {
        this.position = position;
    }
}
