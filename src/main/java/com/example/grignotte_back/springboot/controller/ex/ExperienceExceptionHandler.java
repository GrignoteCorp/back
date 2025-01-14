package com.example.grignotte_back.springboot.controller.ex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExperienceExceptionHandler {

    @ExceptionHandler(NoSuchExperienceException.class)
    public ProblemDetail handleNoSuchFormationException(NoSuchExperienceException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
