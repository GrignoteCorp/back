package com.example.grignotte_back.springboot.controller.controller;

import com.example.grignotte_back.springboot.PatchUtils;
import com.example.grignotte_back.springboot.controller.dto.ExperienceDTO;
import com.example.grignotte_back.springboot.controller.ex.NoSuchExperienceException;
import com.example.grignotte_back.springboot.controller.ex.PatchException;
import com.example.grignotte_back.springboot.domain.model.Id;
import com.example.grignotte_back.springboot.domain.service.ExperienceService;
import com.github.fge.jsonpatch.JsonPatch;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@CrossOrigin
@RequestMapping(path = "/experience")
public class ExperienceController {

    private final ExperienceService experienceService;
    private final PatchUtils patchUtils;

    public ExperienceController(ExperienceService service, PatchUtils patchUtils) {
        this.experienceService = service;
        this.patchUtils = patchUtils;
    }

    @Tag(name = "experience", description = "culinary experience methods")
    @GetMapping(path = "")
    public @ResponseBody Stream<ExperienceDTO> getAllExperiences(){
        return this.experienceService.getExperiences();
    }

    @Tag(name = "experience", description = "culinary experience methods")
    @GetMapping(path = "{id-experience}")
    public @ResponseBody ExperienceDTO getExperience(@PathVariable("id-experience") String id) throws NoSuchExperienceException {
        return this.experienceService.getExperience(id);
    }

    @Tag(name = "experience", description = "culinary experience methods")
    @PostMapping(path = "")
    public Id postExperience(@RequestBody @Valid ExperienceDTO experienceDTO){
        return this.experienceService.createExperience(experienceDTO);
    }

    @Tag(name = "experience", description = "culinary experience methods")
    @PutMapping(path = "{id-experience}")
    public void putExperience(
            @PathVariable("id-experience") String id,
            @RequestBody @Valid ExperienceDTO experienceDTO
    ) throws NoSuchExperienceException {
        this.experienceService.updateExperience(id, experienceDTO);
    }

    @Tag(name = "experience", description = "culinary experience methods")
    @DeleteMapping(path = "{id-experience}")
    public void deleteExperience(@PathVariable("id-experience") String id){
        this.experienceService.deleteExperience(id);
    }

    @Tag(name = "experience", description = "culinary experience methods")
    @PatchMapping(path = "{id-experience}", consumes = "application/json-patch+json")
    public void patchFormation(
            @PathVariable("id-experience") String id,
            @RequestBody JsonPatch patch
    ) throws NoSuchExperienceException, PatchException {
        this.experienceService.updateExperience(id, this.patchUtils.patch(
                this.experienceService.getExperience(id),patch
        ));
    }
}
