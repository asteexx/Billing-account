package com.netcracker.gorbunov.backend.service.impl;

import com.netcracker.gorbunov.backend.entity.UsersEntity;
import com.netcracker.gorbunov.backend.repository.UserRepository;
import com.netcracker.gorbunov.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UsersEntity saveUser(UsersEntity usersEntity) {
        return userRepository.save(usersEntity);
    }

    @Override
    public Optional<UsersEntity> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
