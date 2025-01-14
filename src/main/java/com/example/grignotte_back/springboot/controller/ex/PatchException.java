package com.example.grignotte_back.springboot.controller.ex;

import org.springframework.validation.Errors;

import lombok.Getter;

public class PatchException extends Exception {

    @Getter private final transient Errors errs;

    public PatchException(Exception cause) {
        this(cause, null);
    }

    public PatchException(Errors errs) {
        this(null, errs);
    }

    public PatchException(Exception cause, Errors errs) {
        super(cause);
        this.errs = errs;
    }
}
