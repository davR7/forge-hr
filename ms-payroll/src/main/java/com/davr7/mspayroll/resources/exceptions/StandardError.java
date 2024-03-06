package com.davr7.mspayroll.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StandardError {
    protected Instant timestamp;
    protected String path;
    protected Integer status;
    protected String error;
}
