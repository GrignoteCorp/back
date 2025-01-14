package com.example.grignotte_back.springboot.controller.ex;

import lombok.Getter;

public class NoSuchUserException extends Exception {
    @Getter
    private final String id;
    public NoSuchUserException(String id, Exception cause) {
        super(String.format("L'utilisateur '%s' n'existe pas...", id), cause);
        this.id = id;
    }
    public NoSuchUserException(String id) {
        this(id, null);
    }
}
