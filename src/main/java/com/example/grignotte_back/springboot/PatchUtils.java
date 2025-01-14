package com.example.grignotte_back.springboot;

import com.example.grignotte_back.springboot.controller.ex.PatchException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.validation.SmartValidator;


@Component
public class PatchUtils {

    private final ObjectMapper mapper;
    private final SmartValidator validator;

    public PatchUtils(ObjectMapper mapper, SmartValidator validator) {
        this.mapper = mapper;
        this.validator = validator;
    }

    @SuppressWarnings("unchecked")
    private <T> Class<T> extractClass(T object) {
        return (Class<T>) object.getClass();
    }

    public <W> W patch(W resource, JsonPatch patch) throws PatchException {
        W patched;
        try {
            patched = this.mapper.treeToValue(
                    patch.apply(
                            this.mapper.convertValue(resource, JsonNode.class)
                    ),
                    this.extractClass(resource)
            );
        } catch (JsonProcessingException | IllegalArgumentException | JsonPatchException e) {
            throw new PatchException(e);
        }

        Errors errs = this.validator.validateObject(patched);
        if( errs.hasErrors() ) {
            throw new PatchException(errs);
        }

        return patched;
    }
}
