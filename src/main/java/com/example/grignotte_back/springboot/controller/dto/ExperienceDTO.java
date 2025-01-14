package com.example.grignotte_back.springboot.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ExperienceDTO {
    private String id;
    private String title;
    private String description;
}
