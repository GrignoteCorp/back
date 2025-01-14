package com.example.grignotte_back.springboot.controller.ex;

import lombok.Getter;

public class NoSuchRecipeException extends Exception {
    @Getter
    private final String id;
    public NoSuchRecipeException(String id, Exception cause) {
        super(String.format("La recette '%s' n'existe pas...", id), cause);
        this.id = id;
    }
    public NoSuchRecipeException(String id) {
        this(id, null);
    }
}
