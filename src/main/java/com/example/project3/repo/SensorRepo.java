package com.example.project3.repo;

import com.example.project3.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepo extends JpaRepository<Sensor, Long> {
    Optional<Sensor> findByName(String name);
}
