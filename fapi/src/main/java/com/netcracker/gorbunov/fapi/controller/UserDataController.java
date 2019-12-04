package com.netcracker.gorbunov.fapi.controller;


import com.netcracker.gorbunov.fapi.beClasses.UserModel;
import com.netcracker.gorbunov.fapi.models.UserViewModel;
import com.netcracker.gorbunov.fapi.service.UserDataService;
import com.netcracker.gorbunov.fapi.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserDataController {

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private ConversionService conversionService;

    @GetMapping
    public ResponseEntity<List<UserViewModel>> getAllUsers() {
        return ResponseEntity.ok(userLoginService.findAll()
                .stream()
                .map(chanel -> conversionService.convert(chanel, UserViewModel.class))
                .collect(Collectors.toList()));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserModel> saveUser(@RequestBody UserViewModel userViewModel /*todo server validation*/) {
        if (userViewModel != null) {
            return ResponseEntity.ok(conversionService.convert(
                    userLoginService.save(
                            conversionService.convert(userViewModel, UserModel.class)), UserModel.class));
        }
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userLoginService.deleteUser(Integer.valueOf(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserViewModel> getUserById(@PathVariable Integer id) {
        Integer userId = Integer.valueOf(id);
        return ResponseEntity.ok(conversionService.convert(userLoginService.getUserById(userId), UserViewModel.class));
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<UserViewModel> getUserByLogin(@PathVariable String login) {
        String userLogin = String.valueOf(login);
        return ResponseEntity.ok(conversionService.convert(userLoginService.findByLogin(userLogin), UserViewModel.class));

    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/current")
    public UserModel getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // todo exclude password from model!
        return userLoginService.findByLogin(((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername());
    }
}



