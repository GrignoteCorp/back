package com.example.grignotte_back.springboot.controller.ex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CollectionExceptionHandler {

    @ExceptionHandler(NoSuchCollectionException.class)
    public ProblemDetail handleNoSuchFormationException(NoSuchCollectionException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
