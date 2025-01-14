package com.example.grignotte_back.springboot.controller.ex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatchExceptionHandler {
    @ExceptionHandler(PatchException.class)
    public ProblemDetail handleJsonPatch(PatchException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
