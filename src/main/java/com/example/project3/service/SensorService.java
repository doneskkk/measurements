package com.example.project3.service;

import com.example.project3.model.Sensor;
import com.example.project3.repo.SensorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepo sensorRepo;


    @Autowired
    public SensorService(SensorRepo sensorRepo) {
        this.sensorRepo = sensorRepo;
    }

    public Optional<Sensor> findByName(String name){
        return sensorRepo.findByName(name);
    }

    @Transactional
    public void register(Sensor sensor){
        sensorRepo.save(sensor);
    }
}
