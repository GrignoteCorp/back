package com.example.grignotte_back.springboot.domain.service.impl;

import com.example.grignotte_back.springboot.controller.dto.UserDTO;
import com.example.grignotte_back.springboot.controller.ex.NoSuchUserException;
import com.example.grignotte_back.springboot.domain.mapperDTO.UserMapper;
import com.example.grignotte_back.springboot.domain.model.Id;
import com.example.grignotte_back.springboot.domain.service.UserService;
import com.example.grignotte_back.springboot.repository.entity.UserEntity;
import com.example.grignotte_back.springboot.repository.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Stream;

@Service
public class UserRecipeImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserRecipeImpl(UserRepository repository, UserMapper mapper){
        this.userRepository = repository;
        this.userMapper = mapper;
    }

    @Override
    public Stream<UserDTO> getUsers(){
        Iterable<UserEntity> users = this.userRepository.findAll();
        ArrayList<UserDTO> usersDTO = new ArrayList<>();
        for (UserEntity eUser : users){
            usersDTO.add(this.userMapper.toDTO(eUser));
        }
        return usersDTO.stream();
    }

    @Override
    public UserDTO getUser(String id) throws NoSuchUserException {
        return this.userMapper.toDTO(
                this.userRepository.findById(id).orElseThrow(() -> new NoSuchUserException(id))
        );
    }

    @Override
    public Id createUser(UserDTO user){
        return Id.builder()
                .value(
                        this.userRepository.save(this.userMapper.ToEntity(user)).getId()
                )
                .build();
    }

    @Override
    public void updateUser(String id, UserDTO userPatched) throws NoSuchUserException{
        UserDTO userToPatch = getUser(id);
        userToPatch.setName(userPatched.getName());
        userToPatch.setEmail(userPatched.getEmail());
        userToPatch.setSurname(userPatched.getSurname());
        this.userRepository.save(this.userMapper.ToEntity(userToPatch));
    }

    @Override
    public void deleteUser(String id){
        this.userRepository.deleteById(id);
    }
}
