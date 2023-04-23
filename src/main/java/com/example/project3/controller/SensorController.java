package com.example.project3.controller;

import com.example.project3.dto.SensorDTO;
import com.example.project3.exception.SensorValidator;
import com.example.project3.model.Sensor;
import com.example.project3.service.SensorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.project3.exception.Errors.returnErrorsToClient;

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorController {

    private final ModelMapper modelMapper;
    private final SensorValidator sensorValidator;
    private final SensorService sensorService;

    @Autowired
    public SensorController(ModelMapper modelMapper, SensorValidator sensorValidator, SensorService sensorService) {
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
        this.sensorService = sensorService;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> register(@RequestBody @Valid SensorDTO sensorDTO,
                                               BindingResult bd) {
        Sensor sensor = convertToSensor(sensorDTO);

        sensorValidator.validate(sensor, bd);

        if (bd.hasErrors()) {
            returnErrorsToClient(bd);
        }

        sensorService.register(sensor);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO){
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
