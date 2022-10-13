package com.example.week4jwt.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class ErrorResponse {

    private final String message;

}