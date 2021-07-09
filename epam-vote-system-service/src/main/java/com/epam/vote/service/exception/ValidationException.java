package com.epam.vote.service.exception;

/**
 * Validation Exception.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 30, 2021
 * @author Sapar
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
