package com.example.grignotte_back.springboot.controller.ex;

import lombok.Getter;

public class NoSuchCollectionException extends Exception {
    @Getter
    private final String id;

    public NoSuchCollectionException(String id, Exception cause) {
        super(String.format("La collection '%s' n'existe pas...", id), cause);
        this.id = id;
    }

    public NoSuchCollectionException(String id) {
        this(id, null);
    }
}
