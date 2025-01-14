package com.example.grignotte_back.springboot.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private String surname;
}
