package com.example.grignotte_back.springboot.domain.service.impl;

import com.example.grignotte_back.springboot.controller.dto.ExperienceDTO;
import com.example.grignotte_back.springboot.controller.ex.NoSuchExperienceException;
import com.example.grignotte_back.springboot.domain.mapperDTO.ExperienceMapper;
import com.example.grignotte_back.springboot.domain.model.Id;
import com.example.grignotte_back.springboot.domain.service.ExperienceService;
import com.example.grignotte_back.springboot.repository.entity.ExperienceEntity;
import com.example.grignotte_back.springboot.repository.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Stream;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;

    public ExperienceServiceImpl(ExperienceRepository repository, ExperienceMapper mapper){
        this.experienceRepository = repository;
        this.experienceMapper = mapper;
    }

    @Override
    public Stream<ExperienceDTO> getExperiences(){
        Iterable<ExperienceEntity> experiences = this.experienceRepository.findAll();
        ArrayList<ExperienceDTO> experiencesDTO = new ArrayList<>();
        for (ExperienceEntity eExperience : experiences){
            experiencesDTO.add(this.experienceMapper.toDTO(eExperience));
        }
        return experiencesDTO.stream();
    }

    @Override
    public ExperienceDTO getExperience(String id) throws NoSuchExperienceException{
        return this.experienceMapper.toDTO(
                this.experienceRepository.findById(id).orElseThrow(() -> new NoSuchExperienceException(id))
        );
    }

    @Override
    public Id createExperience(ExperienceDTO experience){
        return Id.builder()
                .value(
                        this.experienceRepository.save(this.experienceMapper.ToEntity(experience)).getId()
                )
                .build();
    }

    @Override
    public void updateExperience(String id, ExperienceDTO experiencePatched) throws NoSuchExperienceException{
        ExperienceDTO experienceToPatch = getExperience(id);
        experienceToPatch.setTitle(experiencePatched.getTitle());
        experienceToPatch.setDescription(experiencePatched.getDescription());

        this.experienceRepository.save(this.experienceMapper.ToEntity(experienceToPatch));
    }

    @Override
    public void deleteExperience(String id){
       this.experienceRepository.deleteById(id);
    }
}
