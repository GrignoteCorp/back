package com.example.grignotte_back.springboot.controller.dto;

import com.example.grignotte_back.springboot.domain.model.RecipeType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class RecipeDTO {

    private String id;
    private String title;
    private RecipeType type;
    private Integer portion;
    private String portionType;
    private Integer cookingTimeHour;
    private Integer cookingTimeMinute;
    private String cookingType;
    private Integer difficulty;
    private Integer cost;
}
