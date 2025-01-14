package com.example.grignotte_back.springboot.repository.repository;

import com.example.grignotte_back.springboot.repository.entity.RecipeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity, String> {
}
