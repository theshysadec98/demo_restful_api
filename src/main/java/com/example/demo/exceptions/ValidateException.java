package com.example.demo.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidateException extends RuntimeException {

    public ValidateException(String message) {
        this.message = message;
    }

    private String message;

    private Object error;

}
