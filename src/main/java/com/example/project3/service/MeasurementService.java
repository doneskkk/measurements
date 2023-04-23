package com.example.project3.service;

import com.example.project3.model.Measurement;
import com.example.project3.repo.MeasurementRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeasurementService {

    private final MeasurementRepo measurementRepo;
    private final SensorService sensorService;

    public List<Measurement> findAll(){
        return measurementRepo.findAll();
    }

    public List<Measurement> findWithPagination(Integer page, Integer size, boolean sortByValue){
        if (sortByValue)
            return measurementRepo.findAll(PageRequest.of(page, size, Sort.by("value"))).getContent();
        else
            return measurementRepo.findAll(PageRequest.of(page,size)).getContent();
    }


    public MeasurementService(MeasurementRepo measurementRepo, SensorService sensorService) {
        this.measurementRepo = measurementRepo;
        this.sensorService = sensorService;
    }

    public void register(Measurement measurement){
        measurement.setSensor(sensorService.findByName(measurement.getSensor().getName()).get());
        measurement.setMeasurementTime(LocalDateTime.now());
        measurementRepo.save(measurement);
    }
}
