package com.example.project3.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class Errors {
    public static void returnErrorsToClient(BindingResult bd){
        StringBuilder errorM = new StringBuilder();

        List<FieldError> errors = bd.getFieldErrors();
        for (FieldError error : errors) {
            errorM.append(error.getField())
                    .append(" - ").append(error.getDefaultMessage() == null ? error.getCode() : error.getDefaultMessage())
                    .append(";");
        }

        throw new MeasurementException(errorM.toString());

    }
}
