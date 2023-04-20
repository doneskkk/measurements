package com.example.project3.repo;

import com.example.project3.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepo extends JpaRepository<Measurement, Long> {
}
