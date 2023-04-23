package com.example.project3.controller;

import com.example.project3.dto.DTOConverter;
import com.example.project3.dto.MeasurementDTO;
import com.example.project3.dto.MeasurementResponse;
import com.example.project3.exception.MeasurementValidator;
import com.example.project3.model.Measurement;
import com.example.project3.service.MeasurementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static com.example.project3.exception.Errors.returnErrorsToClient;

@RestController
@RequestMapping("/api/v1/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;
    private final DTOConverter dtoConverter;
    private final MeasurementValidator measurementValidator;

    public MeasurementController(MeasurementService measurementService, DTOConverter dtoConverter, MeasurementValidator measurementValidator) {
        this.measurementService = measurementService;
        this.dtoConverter = dtoConverter;
        this.measurementValidator = measurementValidator;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody MeasurementDTO measurementDTO, BindingResult bd){
        Measurement measurement =
               dtoConverter.convertToMeasurement(measurementDTO);
        measurementValidator.validate(measurement,bd);

        if (bd.hasErrors())
            returnErrorsToClient(bd);

        measurementService.register(measurement);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<MeasurementResponse> getMeasurements(@RequestParam(value = "page", required = false) Integer page,
                                                               @RequestParam(value = "size", required = false) Integer size,
                                                               @RequestParam(value = "sort_by_value", required = false) boolean sortByValue){
        if(page == null || size == null) {
            return new ResponseEntity<>(new MeasurementResponse(
                    measurementService.findAll()
                            .stream()
                            .map(dtoConverter::convertToMeasurementDTO)
                            .collect(Collectors.toList())), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MeasurementResponse(
                measurementService.findWithPagination(page, size, sortByValue)
                        .stream()
                        .map(dtoConverter::convertToMeasurementDTO)
                        .collect(Collectors.toList())),HttpStatus.OK);

    }

    @GetMapping("/rainyDaysCount")
    public Long rainyDaysCount(){
        return (Long)measurementService.findAll()
                .stream()
                .filter(Measurement::getIsRaining)
                .count();
    }


}
