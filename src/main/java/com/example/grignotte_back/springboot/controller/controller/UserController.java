package com.example.grignotte_back.springboot.controller.controller;

import com.example.grignotte_back.springboot.PatchUtils;
import com.example.grignotte_back.springboot.controller.dto.UserDTO;
import com.example.grignotte_back.springboot.controller.ex.NoSuchUserException;
import com.example.grignotte_back.springboot.controller.ex.PatchException;
import com.example.grignotte_back.springboot.domain.model.Id;
import com.example.grignotte_back.springboot.domain.service.UserService;
import com.github.fge.jsonpatch.JsonPatch;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@CrossOrigin
@RequestMapping(path = "/user") // This means URL's start with /user (after Application path)
public class UserController {

    private final UserService userService;

    private final PatchUtils patchUtils;

    public UserController(UserService userService, PatchUtils patchUtils) {
        this.userService = userService;
        this.patchUtils = patchUtils;
    }

    @Tag(name = "user", description = "User methods")
    @GetMapping(path = "")
    public @ResponseBody Stream<UserDTO> getAllUsers() {
        return this.userService.getUsers();
    }

    @Tag(name = "user", description = "User methods")
    @GetMapping(path = "{id-user}")
    public @ResponseBody UserDTO getUser(@PathVariable("id-user") String id) throws NoSuchUserException {
        return this.userService.getUser(id);
    }

    @Tag(name = "user", description = "User methods")
    @PostMapping(path = "")
    public Id postService(@io.swagger.v3.oas.annotations.parameters.RequestBody @Valid UserDTO userDTO){
        return this.userService.createUser(userDTO);
    }

    @Tag(name = "user", description = "User methods")
    @PutMapping(path = "{id-user}")
    public void putUser(
            @PathVariable("id-user") String id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody @Valid UserDTO userDTO
    ) throws NoSuchUserException {
        this.userService.updateUser(id, userDTO);
    }

    @Tag(name = "user", description = "User methods")
    @DeleteMapping(path = "{id-user}")
    public void deleteUser(@PathVariable("id-user") String id){
        this.userService.deleteUser(id);
    }

    @Tag(name = "user", description = "User methods")
    @PatchMapping(path = "{id-user}", consumes = "application/json-patch+json")
    public void patchFormation(
            @PathVariable("id-user") String id,
            @RequestBody JsonPatch patch
    ) throws NoSuchUserException, PatchException {
        this.userService.updateUser(id, this.patchUtils.patch(
                this.userService.getUser(id),patch
        ));
    }
}