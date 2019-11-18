package com.netcracker.gorbunov.backend.repository;

import com.netcracker.gorbunov.backend.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
}
