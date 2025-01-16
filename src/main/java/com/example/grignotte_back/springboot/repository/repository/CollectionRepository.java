package com.example.grignotte_back.springboot.repository.repository;

import com.example.grignotte_back.springboot.repository.entity.CollectionEntity;
import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<CollectionEntity, String> {
}
