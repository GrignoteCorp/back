package com.example.grignotte_back.springboot.domain.service;

import com.example.grignotte_back.springboot.controller.dto.RecipeDTO;
import com.example.grignotte_back.springboot.controller.ex.NoSuchRecipeException;
import com.example.grignotte_back.springboot.domain.model.Id;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public interface RecipeService {
    Stream<RecipeDTO> getRecipes();
    RecipeDTO getRecipe(String id) throws NoSuchRecipeException;
    Id createRecipe(RecipeDTO recipe);
    void updateRecipe(String id, RecipeDTO recipe) throws NoSuchRecipeException;
    void deleteRecipe(String id);
}
