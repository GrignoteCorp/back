package com.example.grignotte_back.springboot.domain.service.impl;

import com.example.grignotte_back.springboot.controller.dto.CollectionDTO;
import com.example.grignotte_back.springboot.controller.ex.NoSuchCollectionException;
import com.example.grignotte_back.springboot.domain.mapperDTO.CollectionMapper;
import com.example.grignotte_back.springboot.domain.model.Id;
import com.example.grignotte_back.springboot.domain.service.CollectionService;
import com.example.grignotte_back.springboot.repository.entity.CollectionEntity;
import com.example.grignotte_back.springboot.repository.repository.CollectionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Stream;

@Service
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepository;
    private final CollectionMapper collectionMapper;

    public CollectionServiceImpl(CollectionRepository repository, CollectionMapper mapper) {
        this.collectionRepository = repository;
        this.collectionMapper = mapper;
    }

    @Override
    public Stream<CollectionDTO> getCollections() {
        Iterable<CollectionEntity> collections = this.collectionRepository.findAll();
        ArrayList<CollectionDTO> collectionsDTO = new ArrayList<>();
        for (CollectionEntity eCollection : collections) {
            collectionsDTO.add(this.collectionMapper.toDTO(eCollection));
        }
        return collectionsDTO.stream();
    }

    @Override
    public CollectionDTO getCollection(String id) throws NoSuchCollectionException {
        return this.collectionMapper.toDTO(
                this.collectionRepository.findById(id).orElseThrow(() -> new NoSuchCollectionException(id))
        );
    }

    @Override
    public Id createCollection(CollectionDTO collection) {
        return Id.builder()
                .value(
                        this.collectionRepository.save(this.collectionMapper.ToEntity(collection)).getId()
                )
                .build();
    }

    @Override
    public void updateCollection(String id, CollectionDTO collectionPatched) throws NoSuchCollectionException {
        CollectionDTO collectionToPatch = getCollection(id);
        collectionToPatch.setTitle(collectionPatched.getTitle());
        collectionToPatch.setDescription(collectionPatched.getDescription());

        this.collectionRepository.save(this.collectionMapper.ToEntity(collectionToPatch));
    }

    @Override
    public void deleteCollection(String id) {
        this.collectionRepository.deleteById(id);
    }
}
