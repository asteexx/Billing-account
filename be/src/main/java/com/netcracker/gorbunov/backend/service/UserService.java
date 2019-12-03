package com.netcracker.gorbunov.backend.service;

import com.netcracker.gorbunov.backend.entity.UsersEntity;

import java.util.Optional;

public interface UserService {

    UsersEntity saveUser(UsersEntity usersEntity);
    Optional<UsersEntity> getUserById(Integer id);
    Iterable<UsersEntity> getAllUsers();
    Optional<UsersEntity> findByLogin(String login);
    void deleteUser(Integer id);

}
