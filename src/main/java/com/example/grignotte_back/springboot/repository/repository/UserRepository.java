package com.example.grignotte_back.springboot.repository.repository;

import com.example.grignotte_back.springboot.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

}