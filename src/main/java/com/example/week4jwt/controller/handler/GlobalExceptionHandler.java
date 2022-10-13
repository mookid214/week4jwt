package com.example.week4jwt.controller.handler;

import com.example.week4jwt.entity.exception.DBEmptyDataException;
import com.example.week4jwt.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DBEmptyDataException.class)
    public ResponseEntity<ErrorResponse> handleDataAccessException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        log.error("error: ()", errorResponse.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}