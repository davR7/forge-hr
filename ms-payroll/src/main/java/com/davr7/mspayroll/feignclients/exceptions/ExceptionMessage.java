package com.davr7.mspayroll.feignclients.exceptions;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExceptionMessage {
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
