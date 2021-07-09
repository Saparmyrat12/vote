package com.epam.vote.controller;

import com.epam.vote.service.exception.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Rest Exception Handler.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июль 07, 2021
 * @author Sapar
 */
@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException validationException) {
        LOGGER.error(validationException.getMessage());
        return error(HttpStatus.BAD_REQUEST, validationException);
    }

    private ResponseEntity<?> error(HttpStatus status, Exception e) {
        LOGGER.error("Exception : ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
