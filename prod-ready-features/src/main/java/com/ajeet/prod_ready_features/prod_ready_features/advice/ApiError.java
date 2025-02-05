package com.ajeet.prod_ready_features.prod_ready_features.advice;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {

    private LocalDateTime timeStamp;
    private String message;
    private HttpStatus statusCode;

    public ApiError()
    {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiError(String message, HttpStatus statusCode) {
        this();
        this.message = message;
        this.statusCode = statusCode;
    }
}
