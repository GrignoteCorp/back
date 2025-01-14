package com.example.grignotte_back.springboot.domain.service.impl;

import com.example.grignotte_back.springboot.controller.dto.RecipeDTO;
import com.example.grignotte_back.springboot.controller.ex.NoSuchRecipeException;
import com.example.grignotte_back.springboot.domain.mapperDTO.RecipeMapper;
import com.example.grignotte_back.springboot.domain.model.Id;
import com.example.grignotte_back.springboot.domain.service.RecipeService;
import com.example.grignotte_back.springboot.repository.entity.RecipeEntity;
import com.example.grignotte_back.springboot.repository.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Stream;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeServiceImpl(RecipeRepository repository, RecipeMapper mapper){
        this.recipeRepository = repository;
        this.recipeMapper = mapper;
    }

    @Override
    public Stream<RecipeDTO> getRecipes(){
        Iterable<RecipeEntity> recipes = this.recipeRepository.findAll();
        ArrayList<RecipeDTO> recipesDTO = new ArrayList<>();
        for (RecipeEntity eRecipe : recipes){
            recipesDTO.add(this.recipeMapper.toDTO(eRecipe));
        }
        return recipesDTO.stream();
    }

    @Override
    public RecipeDTO getRecipe(String id) throws NoSuchRecipeException {
        return this.recipeMapper.toDTO(
                this.recipeRepository.findById(id).orElseThrow(() -> new NoSuchRecipeException(id))
        );
    }

    @Override
    public Id createRecipe(RecipeDTO recipe){
        return Id.builder()
                .value(
                        this.recipeRepository.save(this.recipeMapper.ToEntity(recipe)).getId()
                )
                .build();
    }

    @Override
    public void updateRecipe(String id, RecipeDTO recipePatched) throws NoSuchRecipeException{
        RecipeDTO recipeToPatch = getRecipe(id);
        recipeToPatch.setTitle(recipePatched.getTitle());
        recipeToPatch.setType(recipePatched.getType());
        recipeToPatch.setPortion(recipePatched.getPortion());
        recipeToPatch.setPortionType(recipePatched.getPortionType());
        recipeToPatch.setCookingTimeHour(recipePatched.getCookingTimeHour());
        recipeToPatch.setCookingTimeMinute(recipePatched.getCookingTimeMinute());
        recipeToPatch.setCookingType(recipePatched.getCookingType());
        recipeToPatch.setDifficulty(recipePatched.getDifficulty());
        recipeToPatch.setCost(recipePatched.getCost());

        this.recipeRepository.save(this.recipeMapper.ToEntity(recipeToPatch));
    }

    @Override
    public void deleteRecipe(String id){
        this.recipeRepository.deleteById(id);
    }
}
