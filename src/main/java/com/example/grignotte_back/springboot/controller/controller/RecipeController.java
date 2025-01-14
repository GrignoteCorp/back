package com.example.grignotte_back.springboot.controller.controller;

import com.example.grignotte_back.springboot.PatchUtils;
import com.example.grignotte_back.springboot.controller.dto.RecipeDTO;
import com.example.grignotte_back.springboot.controller.ex.NoSuchRecipeException;
import com.example.grignotte_back.springboot.controller.ex.PatchException;
import com.example.grignotte_back.springboot.domain.model.Id;
import com.example.grignotte_back.springboot.domain.service.RecipeService;
import com.github.fge.jsonpatch.JsonPatch;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@CrossOrigin
@RequestMapping(path = "/recipe")
@Tag(name = "recipe", description = "Recipe Methods")
public class RecipeController {
    private final RecipeService recipeService;
    private final PatchUtils patchUtils;

    public RecipeController(RecipeService service, PatchUtils patchUtils) {
        this.recipeService = service;
        this.patchUtils = patchUtils;
    }

    @GetMapping(path = "")
    public @ResponseBody Stream<RecipeDTO> getAllRecipes(){
        return this.recipeService.getRecipes();
    }

    @GetMapping(path = "{id-recipe}")
    public @ResponseBody RecipeDTO getRecipe(@PathVariable("id-recipe") String id) throws NoSuchRecipeException {
        return this.recipeService.getRecipe(id);
    }

    @PostMapping(path = "")
    public Id postRecipe(@RequestBody @Valid RecipeDTO recipeDTO){
        return this.recipeService.createRecipe(recipeDTO);
    }

    @PutMapping(path = "{id-recipe}")
    public void putRecipe(
            @PathVariable("id-recipe") String id,
            @RequestBody @Valid RecipeDTO recipeDTO
    ) throws NoSuchRecipeException {
        this.recipeService.updateRecipe(id, recipeDTO);
    }

    @DeleteMapping(path = "{id-recipe}")
    public void deleteRecipe(@PathVariable("id-recipe") String id){
        this.recipeService.deleteRecipe(id);
    }

    @PatchMapping(path = "{id-recipe}", consumes = "application/json-patch+json")
    public void patchFormation(
            @PathVariable("id-recipe") String id,
            @RequestBody JsonPatch patch
    ) throws NoSuchRecipeException, PatchException {
        this.recipeService.updateRecipe(id, this.patchUtils.patch(
                this.recipeService.getRecipe(id),patch
        ));
    }
}
