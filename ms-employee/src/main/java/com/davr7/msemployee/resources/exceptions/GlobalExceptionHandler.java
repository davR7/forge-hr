package com.davr7.msemployee.resources.exceptions;

import com.davr7.msemployee.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseError handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest req) {
        String error = "Not Found";
        return new ResponseError(Instant.now(), req.getRequestURI(), HttpStatus.NOT_FOUND.value(), error, e.getMessage());
    }
}
