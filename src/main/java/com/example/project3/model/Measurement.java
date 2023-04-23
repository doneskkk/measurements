package com.example.project3.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Measurement")
@Data
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Max(100)
    @Min(-100)
    @Column(name = "value")
    private Double value;

    @Column(name = "raining")
    @NotNull
    private Boolean isRaining;

    @Column(name = "measurement_date_time")
    private LocalDateTime measurementTime;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private Sensor sensor;

}
