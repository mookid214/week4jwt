package com.example.week4jwt.entity.exception;

public class DBEmptyDataException extends RuntimeException{

    public DBEmptyDataException() {

    }
    public DBEmptyDataException(String message) {
        super(message);
    }
}