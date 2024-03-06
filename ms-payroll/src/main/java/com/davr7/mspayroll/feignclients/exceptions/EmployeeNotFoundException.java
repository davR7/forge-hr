package com.davr7.mspayroll.feignclients.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message, Exception exception) {
        super(message, exception);
    }
}
