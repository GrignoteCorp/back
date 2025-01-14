package com.example.grignotte_back.springboot.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Please provide a title")
    @Size(min = 1, max = 50)
    private String title;

    @NotNull(message = "Please choose a recipe type")
    private RecipeType type;

    @NotNull
    @Min(1)
    private Integer portion;

    @NotNull
    @Size(min = 1, max = 50)
    private String portionType;

    @NotNull
    private Integer cookingTimeHour;

    @NotNull
    private Integer cookingTimeMinute;

    @NotNull
    @Size(min = 1, max = 50)
    private String cookingType;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer difficulty;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
    }

    public Integer getPortion() {
        return portion;
    }

    public void setPortion(Integer portion) {
        this.portion = portion;
    }

    public String getPortionType() {
        return portionType;
    }

    public void setPortionType(String portionType) {
        this.portionType = portionType;
    }

    public Integer getCookingTimeHour() {
        return cookingTimeHour;
    }

    public void setCookingTimeHour(Integer cookingTimeHour) {
        this.cookingTimeHour = cookingTimeHour;
    }

    public Integer getCookingTimeMinute() {
        return cookingTimeMinute;
    }

    public void setCookingTimeMinute(Integer cookingTimeMinute) {
        this.cookingTimeMinute = cookingTimeMinute;
    }

    public String getCookingType() {
        return cookingType;
    }

    public void setCookingType(String cookingType) {
        this.cookingType = cookingType;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
