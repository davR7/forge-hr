package com.davr7.mspayroll.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponseError extends StandardError {
    private String message;

    public ResponseError(Instant timestamp, String path, Integer status, String error, String message) {
        super(timestamp, path, status, error);
        this.message = message;
    }
}
