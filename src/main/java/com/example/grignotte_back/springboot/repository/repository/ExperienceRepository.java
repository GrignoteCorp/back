package com.example.grignotte_back.springboot.repository.repository;

import com.example.grignotte_back.springboot.repository.entity.ExperienceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository<ExperienceEntity, String> {
}
