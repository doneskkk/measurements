package com.example.project3.exception;


import com.example.project3.model.Measurement;
import com.example.project3.service.SensorService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement m = (Measurement) target;

        if (m.getSensor() == null) {
            return;
        }

        if(sensorService.findByName(m.getSensor().getName()).isEmpty()){
            errors.rejectValue("sensor", "There is not a sensor with that name");
        }
    }
}



