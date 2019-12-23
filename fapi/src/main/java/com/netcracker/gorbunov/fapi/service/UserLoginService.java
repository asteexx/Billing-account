package com.netcracker.gorbunov.fapi.service;

import com.netcracker.gorbunov.fapi.beClasses.UserModel;
import com.netcracker.gorbunov.fapi.models.UserViewModel;

import javax.validation.constraints.Null;
import javax.xml.ws.http.HTTPException;
import java.util.List;
import java.util.Set;

public interface UserLoginService {
    UserModel findByLogin(String login) throws HTTPException;
    List<UserModel> findAll();
    UserModel save(UserModel user);
    void deleteUser(Integer id);
    UserModel getUserById(Integer id);
    Set getAuthority(UserModel user);
}
