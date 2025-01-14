package com.example.grignotte_back.springboot.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@Table(name = "formations")
public class ExperienceEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;
    private String description;
}
