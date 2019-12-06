package com.netcracker.gorbunov.fapi.service;

import com.netcracker.gorbunov.fapi.beClasses.UserModel;
import com.netcracker.gorbunov.fapi.models.UserViewModel;

import java.util.List;
import java.util.Set;

public interface UserLoginService {
    UserModel findByLogin(String login);
    List<UserModel> findAll();
    UserModel save(UserModel user); // TODO: 27.11.2019 check this
    void deleteUser(Integer id);
    UserModel getUserById(Integer id);
    Set getAuthority(UserModel user);
}
