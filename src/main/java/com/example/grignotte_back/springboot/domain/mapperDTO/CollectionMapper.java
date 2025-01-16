package com.example.grignotte_back.springboot.domain.mapperDTO;

import com.example.grignotte_back.springboot.controller.dto.CollectionDTO;
import com.example.grignotte_back.springboot.repository.entity.CollectionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CollectionMapper {
    public abstract CollectionEntity ToEntity(CollectionDTO collectionDTO);

    public abstract CollectionDTO toDTO(CollectionEntity eCollection);

}
