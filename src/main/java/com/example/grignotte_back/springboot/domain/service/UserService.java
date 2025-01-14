package com.example.grignotte_back.springboot.domain.service;

import com.example.grignotte_back.springboot.controller.dto.UserDTO;
import com.example.grignotte_back.springboot.controller.ex.NoSuchUserException;
import com.example.grignotte_back.springboot.domain.model.Id;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public interface UserService {
    Stream<UserDTO> getUsers();
    UserDTO getUser(String id) throws NoSuchUserException;
    Id createUser(UserDTO userDTO);
    void updateUser(String id, UserDTO userDTO) throws NoSuchUserException;
    void deleteUser(String id);
}
