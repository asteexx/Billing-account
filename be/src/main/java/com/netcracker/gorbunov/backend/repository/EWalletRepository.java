package com.netcracker.gorbunov.backend.repository;

import com.netcracker.gorbunov.backend.entity.EWalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EWalletRepository extends JpaRepository<EWalletEntity, Integer> {
    Optional<EWalletEntity> findBySubscriberId(Integer subscriberId);
}
