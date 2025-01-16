package com.example.grignotte_back.springboot.domain.service;

import com.example.grignotte_back.springboot.controller.dto.CollectionDTO;
import com.example.grignotte_back.springboot.controller.ex.NoSuchCollectionException;
import com.example.grignotte_back.springboot.domain.model.Id;

import java.util.stream.Stream;

public interface CollectionService {
    Stream<CollectionDTO> getCollections();

    CollectionDTO getCollection(String id) throws NoSuchCollectionException;

    Id createCollection(CollectionDTO collection);

    void updateCollection(String id, CollectionDTO collection) throws NoSuchCollectionException;

    void deleteCollection(String id);

}
