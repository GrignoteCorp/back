package com.example.grignotte_back.springboot.domain.service;

import com.example.grignotte_back.springboot.controller.ex.NoSuchExperienceException;
import com.example.grignotte_back.springboot.controller.dto.ExperienceDTO;
import com.example.grignotte_back.springboot.domain.model.Id;

import java.util.stream.Stream;

public interface ExperienceService {
    Stream<ExperienceDTO> getExperiences();
    ExperienceDTO getExperience(String id) throws NoSuchExperienceException;
    Id createExperience(ExperienceDTO experience);
    void updateExperience(String id, ExperienceDTO experience) throws NoSuchExperienceException;
    void deleteExperience(String id);

}
