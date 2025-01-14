package com.example.grignotte_back.springboot.repository.entity;

import com.example.grignotte_back.springboot.domain.model.RecipeType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@Table(name = "recipe")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
