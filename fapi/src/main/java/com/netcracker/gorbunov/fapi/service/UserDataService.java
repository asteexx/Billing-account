package com.netcracker.gorbunov.fapi.service;

import com.netcracker.gorbunov.fapi.beClasses.UserModel;
import com.netcracker.gorbunov.fapi.models.UserViewModel;

import java.util.List;

public interface UserDataService {
    List<UserModel> getAllUsers();

    UserModel getUserById(Integer id);

    UserModel saveUser(UserModel userModel);

    void deleteUser(Integer id);
}
