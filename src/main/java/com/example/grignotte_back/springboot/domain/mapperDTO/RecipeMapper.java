package com.example.grignotte_back.springboot.domain.mapperDTO;

import com.example.grignotte_back.springboot.controller.dto.RecipeDTO;
import com.example.grignotte_back.springboot.repository.entity.RecipeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RecipeMapper {

    public abstract RecipeEntity ToEntity(RecipeDTO recipeDTO);

    public abstract RecipeDTO toDTO(RecipeEntity eRecipe);
}
