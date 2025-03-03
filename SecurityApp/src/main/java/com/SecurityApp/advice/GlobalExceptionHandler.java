package com.SecurityApp.advice;


import com.SecurityApp.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException exception) {
            ApiError apiError=new ApiError(exception.getMessage(), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleBadCredentialsException(BadCredentialsException exception) {
        ApiError apiError=new ApiError(exception.getMessage(),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }
}
