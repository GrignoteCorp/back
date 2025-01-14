package com.example.grignotte_back.springboot.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
public class Id {
    @Getter @Setter private String value;
}
