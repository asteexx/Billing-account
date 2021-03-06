package com.netcracker.gorbunov.backend.controller;

import com.netcracker.gorbunov.backend.entity.UsersEntity;
import com.netcracker.gorbunov.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController implements WebMvcConfigurer {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsersEntity> getUserById(@PathVariable(name = "id") Integer id) {
        Optional<UsersEntity> usersEntity = userService.getUserById(id);
        if (usersEntity.isPresent()) {
            return ResponseEntity.ok(usersEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/login/{login}")
    public ResponseEntity<UsersEntity> getUserByLogin( @PathVariable(name = "login") String login) {
        Optional<UsersEntity> usersEntity = userService.findByLogin(login);
        if (usersEntity.isPresent()) {
            return ResponseEntity.ok(usersEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "")
    public Iterable<UsersEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(("/signup"))
    public UsersEntity saveUser( @RequestBody UsersEntity usersEntity) {



        return userService.saveUser(usersEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "id") Integer id) {
        userService.deleteUser(id);
    }



}
