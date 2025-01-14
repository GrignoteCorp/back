package com.example.grignotte_back.springboot.controller.ex;

import lombok.Getter;

public class NoSuchExperienceException extends Exception {
    @Getter
    private final String id;
    public NoSuchExperienceException(String id, Exception cause) {
        super(String.format("L'expérience '%s' n'existe pas...", id), cause);
        this.id = id;
    }
    public NoSuchExperienceException(String id) {
        this(id, null);
    }
}
