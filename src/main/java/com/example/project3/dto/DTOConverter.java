package com.example.project3.dto;

import com.example.project3.model.Measurement;
import com.example.project3.model.Sensor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DTOConverter {
    private final ModelMapper modelMapper;

    public DTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Sensor convertToSensor(SensorDTO sensorDTO){
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    public Measurement convertToMeasurement(MeasurementDTO measurementDTO){
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    public MeasurementDTO convertToMeasurementDTO(Measurement measurement){
        return modelMapper.map(measurement, MeasurementDTO.class);
    }

}

