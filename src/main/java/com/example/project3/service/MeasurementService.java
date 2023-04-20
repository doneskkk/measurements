package com.example.project3.service;

import com.example.project3.repo.MeasurementRepo;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {

    private final MeasurementRepo measurementRepo;
    private final SensorService sensorService;

    public MeasurementService(MeasurementRepo measurementRepo, SensorService sensorService) {
        this.measurementRepo = measurementRepo;
        this.sensorService = sensorService;
    }
}
