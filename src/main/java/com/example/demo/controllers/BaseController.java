package com.example.demo.controllers;

import com.example.demo.exceptions.Error;
import com.example.demo.exceptions.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@Slf4j
public class BaseController implements ErrorController {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Error> handleException(Exception exception) {
        log.error("Caught a server exception", exception);
        return new ResponseEntity<>(
                Error.builder()
                        .messages(Collections.singletonList("Unexpected error"))
                        .code(Error.CodeEnum.UNEXPECTED_ERROR)
                        .data(ExceptionUtils.stackTraceToListMessages(exception.getStackTrace()))
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
