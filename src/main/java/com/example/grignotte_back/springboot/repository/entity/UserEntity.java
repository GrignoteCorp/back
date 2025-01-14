package com.example.grignotte_back.springboot.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String surname;
}
