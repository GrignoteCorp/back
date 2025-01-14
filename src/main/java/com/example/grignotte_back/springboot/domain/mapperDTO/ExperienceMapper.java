package com.example.grignotte_back.springboot.domain.mapperDTO;

import com.example.grignotte_back.springboot.controller.dto.ExperienceDTO;
import com.example.grignotte_back.springboot.repository.entity.ExperienceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ExperienceMapper {
    public abstract ExperienceEntity ToEntity(ExperienceDTO experienceDTO);
    public abstract ExperienceDTO toDTO(ExperienceEntity eExperience);

}
