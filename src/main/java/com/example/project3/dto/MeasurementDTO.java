package com.example.project3.dto;

import com.example.project3.model.Sensor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MeasurementDTO {

    @Max(100)
    @Min(-100)
    private Double value;

    @NotNull
    private Boolean isRaining;

    @NotNull
    private Sensor sensor;

}
