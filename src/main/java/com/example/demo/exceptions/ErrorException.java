package com.example.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorException extends RuntimeException {

    private Error error;
    private HttpStatus status;


    public static ErrorException notFound(String message) {
        return new ErrorException(
                Error.builder()
                        .code(Error.CodeEnum.NOT_FOUND)
                        .messages(List.of(message))
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
}