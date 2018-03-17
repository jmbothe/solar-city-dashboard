package com.example.employeesapi.repositories;

import com.example.employeesapi.models.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository <Position, Long> {

}
