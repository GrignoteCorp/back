package com.example.grignotte_back.springboot.controller.controller;

import com.example.grignotte_back.springboot.PatchUtils;
import com.example.grignotte_back.springboot.controller.dto.CollectionDTO;
import com.example.grignotte_back.springboot.controller.ex.NoSuchCollectionException;
import com.example.grignotte_back.springboot.controller.ex.PatchException;
import com.example.grignotte_back.springboot.domain.model.Id;
import com.example.grignotte_back.springboot.domain.service.CollectionService;
import com.github.fge.jsonpatch.JsonPatch;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@CrossOrigin
@RequestMapping(path = "/collection")
public class CollectionController {

    private final CollectionService collectionService;
    private final PatchUtils patchUtils;

    public CollectionController(CollectionService service, PatchUtils patchUtils) {
        this.collectionService = service;
        this.patchUtils = patchUtils;
    }

    @Tag(name = "collection", description = "culinary collection methods")
    @GetMapping(path = "")
    public @ResponseBody Stream<CollectionDTO> getAllCollections() {
        return this.collectionService.getCollections();
    }

    @Tag(name = "collection", description = "culinary collection methods")
    @GetMapping(path = "{id-collection}")
    public @ResponseBody CollectionDTO getCollection(@PathVariable("id-collection") String id) throws NoSuchCollectionException {
        return this.collectionService.getCollection(id);
    }

    @Tag(name = "collection", description = "culinary collection methods")
    @PostMapping(path = "")
    public Id postCollection(@RequestBody @Valid CollectionDTO collectionDTO) {
        return this.collectionService.createCollection(collectionDTO);
    }

    @Tag(name = "collection", description = "culinary collection methods")
    @PutMapping(path = "{id-collection}")
    public void putCollection(
            @PathVariable("id-collection") String id,
            @RequestBody @Valid CollectionDTO collectionDTO
    ) throws NoSuchCollectionException {
        this.collectionService.updateCollection(id, collectionDTO);
    }

    @Tag(name = "collection", description = "culinary collection methods")
    @DeleteMapping(path = "{id-collection}")
    public void deleteCollection(@PathVariable("id-collection") String id) {
        this.collectionService.deleteCollection(id);
    }

    @Tag(name = "collection", description = "culinary collection methods")
    @PatchMapping(path = "{id-collection}", consumes = "application/json-patch+json")
    public void patchFormation(
            @PathVariable("id-collection") String id,
            @RequestBody JsonPatch patch
    ) throws NoSuchCollectionException, PatchException {
        this.collectionService.updateCollection(id, this.patchUtils.patch(
                this.collectionService.getCollection(id), patch
        ));
    }
}
