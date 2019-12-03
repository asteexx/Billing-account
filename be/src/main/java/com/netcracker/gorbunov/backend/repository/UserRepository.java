package com.netcracker.gorbunov.backend.repository;

import com.netcracker.gorbunov.backend.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
   Optional<UsersEntity> findByLogin(String login);
}
