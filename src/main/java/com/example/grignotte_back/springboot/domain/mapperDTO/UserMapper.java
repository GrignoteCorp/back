package com.example.grignotte_back.springboot.domain.mapperDTO;

import com.example.grignotte_back.springboot.controller.dto.UserDTO;
import com.example.grignotte_back.springboot.repository.entity.UserEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract UserEntity ToEntity(UserDTO userDTO);
    public abstract UserDTO toDTO(UserEntity eUser);

}
